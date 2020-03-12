import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import model.*;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BookinApp {
    private FlightController flightController = new FlightController();
    private BookingController bookingController = new BookingController();
    private UserController userController = new UserController();
    Inputs inputs = new Inputs();

    void menu1() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================================\n");
        sb.append("|                  BOOKING APP                  |\n");
        sb.append("=================================================\n");
        sb.append("|   1. Online Board.                            |\n");
        sb.append("|   2. Show the flight info.                    |\n");
        sb.append("|   3. Search and book a flight.                |\n");
        sb.append("|   4. Cancel the booking.                      |\n");
        sb.append("|   5. My flights.                              |\n");
        sb.append("|   6. Exit                                     |\n");
        sb.append("=================================================\n");
        System.out.println(sb);
    }

    void menu2() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("==================================================\n");
        sb2.append("|                       MENU                     |\n");
        sb2.append("==================================================\n");
        sb2.append("|   1. Booking.                                  |\n");
        sb2.append("|   2. Return main menu         .                |\n");
        sb2.append("==================================================\n");
        System.out.println(sb2);
    }

    void menu0() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("==================================================\n");
        sb2.append("|                       MENU                      |\n");
        sb2.append("==================================================\n");
        sb2.append("|   1. Log In.                                    |\n");
        sb2.append("|   2. Sign Up.                                   |\n");
        sb2.append("|   3. Exit.                                      |\n");
        sb2.append("==================================================\n");
        System.out.println(sb2);
    }

    public void run() throws IOException, ClassNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean flag0 = true;
        while (flag0) {
            boolean flag1 = false;
            menu0();
            String menu0item = scanner.next();


            switch (menu0item) {
                case "1":
                    try {
                        userController.getUser(new User(inputs.inputUsername(), inputs.inputPssword()));
                        flag1 = true;
                    } catch (Exception e) {
                        System.out.println("User doesn't exist, please sign up!");
                        flag1 = false;
                    }
                    break;
                case "2":
                    userController.creatNewUser(new User(inputs.inputUsername(), inputs.inputPssword()));
                    break;
                case "3":
                    flag0 = false;
                    break;
                default:
                    System.out.println("Invalid menu item. Enter menu item.");
                    break;

            }


            while (flag1) {
                menu1();
                String menuItem = scanner.next();
                switch (menuItem) {

                    case "1":
                        flightController.getAll();
                        break;
                    case "2":
                        flightController.getById(inputs.inputId());
                        break;
                    case "3":
                        boolean flag2 = true;
                        int tickets = 0;
                        try {
                            String city = inputs.inputCity();
                            LocalDate date = inputs.inputDate();
                            boolean validticket=true;
                            while (validticket) {
                                tickets = inputs.inputTickets();
                                if (tickets>0){
                                    validticket=false;
                                }else{
                                    System.out.println("Ticket count has to be at least 1!");
                                }
                            }
                            flightController.search(new Flight(City.valueOf(city), date));
                        } catch (InputMismatchException im) {
                            System.out.println("Something went wrong");
                            flag2 = false;
                        } catch (Exception ex) {
                            System.out.println("Date format is not true!");
                            flag2 = false;
                        }

                        while (flag2) {
                            menu2();
                            String press = scanner.next();
                            switch (press) {
                                case "1":
                                    bookingController.makeBooking(tickets);
                                    break;
                                case "2":
                                    flag2 = false;
                                    break;
                                default:
                                    System.out.println("Invalid menu item. Enter menu item.");
                                    break;
                            }
                        }
                        break;
                    case "4":
                        bookingController.cancelBooking(inputs.inputCancelId());
                        break;
                    case "5":
                        bookingController.showMyBookings();
                        break;
                    case "6":
                        Session.setUser(null);
                        flag1 = false;
                        break;

                    default:
                        System.out.println("Invalid menu item!");
                        break;
                }
            }
        }
    }
}
