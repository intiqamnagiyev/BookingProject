import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import model.City;
import model.Flight;
import model.Session;
import model.User;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class BookinApp {
    private FlightController flightController = new FlightController();
    private BookingController bookingController = new BookingController();
    private UserController userController = new UserController();

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

    public void run() throws IOException {
        // Flight.createSchedule();
        Scanner scanner = new Scanner(System.in);
        boolean flag0 = true;
        while (flag0) {
            boolean flag1 = false;
            menu0();
            int menu0item = 0;
            try {
                menu0item = scanner.nextInt();
            } catch (Exception e) {
                menu0item=0;
                System.out.println("invalid menu num format");
            }

            switch (menu0item) {
                case 1:
                    System.out.println("Username:");
                    String username = scanner.next();
                    System.out.println("password:");
                    String password = scanner.next();
                    try {
                        userController.getUser(new User(username, password));
                        flag1 = true;
                    } catch (Exception e) {
                        System.out.println("user not exist, please sign up");
                        flag1 = false;
                    }
                    break;
                case 2:
                    System.out.println("Username:");
                    String usernamenew = scanner.next();
                    System.out.println("password:");
                    String passwordnew = scanner.next();
                    userController.creatNewUser(new User(usernamenew, passwordnew));
                    break;
                case 3:
                    flag0 = false;
                    break;
                default:
                    System.out.println("Invalid menu item. Enter menu item.");
                    break;

            }


            while (flag1) {

                menu1();
                int menuItem = scanner.nextInt();
                switch (menuItem) {

                    case 1:
                        flightController.getAll();
                        break;
                    case 2:
                        System.out.print("Enter ID of flight: ");
                        int id = scanner.nextInt();
                        flightController.getById(id);
                        break;
                    case 3:
                        boolean flag2 = true;
                        int tickets = 0;
                        try {
                            System.out.println("Enter destination city: ");
                            String city = scanner.next().toUpperCase();

                            System.out.println("Enter date:yyyy-MM-dd");
                            LocalDate date = LocalDate.parse(scanner.next());

                            System.out.println("Enter number of tickets: ");
                            tickets = scanner.nextInt();
                            flightController.search(new Flight(City.valueOf(city), date));
                        } catch (InputMismatchException im) {
                            System.out.println("smthng went wrong");
                            flag2 = false;
                        } catch (Exception ex) {
                            System.out.println("date format is not true");
                            flag2 = false;
                        }

                        while (flag2) {
                            menu2();
                            int press = scanner.nextInt();
                            switch (press) {
                                case 1:
                                    bookingController.makeBooking(tickets);
                                    break;
                                case 2:
                                    flag2 = false;
                                    break;
                                default:
                                    System.out.println("Invalid menu item. Enter menu item.");
                                    break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Enter Booking ID: ");
                        int cancelID = scanner.nextInt();
                        bookingController.cancelBooking(cancelID);
                        break;
                    case 5:
                        bookingController.showMyBookings();
                        break;
                    case 6:
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
