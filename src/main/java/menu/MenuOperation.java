package menu;

import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import model.City;
import model.Flight;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuOperation {
    private BookingController bookingController = new BookingController();
    private FlightController flightController = new FlightController();
    private UserController userController = new UserController();
    Scanner scanner = new Scanner(System.in);

    public boolean getUser() {
        System.out.println("Username:");
        String username = scanner.next();
        System.out.println("Password:");
        String password = scanner.next();
        try {
            userController.getUser(new User(username, password));
            return true;
        } catch (Exception e) {
            System.out.println("User doesn't exist, please sign up!");
            return false;
        }
    }

    public void createNewUser() {
        System.out.println("Username:");
        String usernamenew = scanner.next();
        System.out.println("Password:");
        String passwordnew = scanner.next();
        userController.creatNewUser(new User(usernamenew, passwordnew));
    }

    public void getAllFlights() {
        flightController.getAll();
    }

    public void getFlightById() {
        System.out.print("Enter ID of flight: ");
        int id = scanner.nextInt();
        flightController.getById(id);
    }

    public boolean searchFligtsForBooking() {
        try {
            System.out.println("Enter destination city: ");
            String city = scanner.next().toUpperCase();

            System.out.println("Enter date(like YYYY-MM-DD:");
            LocalDate date = LocalDate.parse(scanner.next());

            flightController.search(new Flight(City.valueOf(city), date));
            return true;
        } catch (IllegalArgumentException im) {
            System.out.println("Such city hasn't found");
            return false;
        } catch (DateTimeParseException dtpe) {
            System.out.println("Invalid date format, please enter data yyy-MM-dd format");
            return false;
        } catch (Exception ex) {
            System.out.println("Date format is not true!");
            return false;
        }
    }

    public void makeBooking() {
        boolean validate = true;
        while (validate) {
            System.out.println("Enter number of tickets: ");
            int tickets = scanner.nextInt();
            if (tickets > 0) {
                bookingController.makeBooking(tickets);
                validate = false;
            } else {
                System.out.println("Ticket count has to be at least 1!");
            }
        }
    }

    public void cancelBooking() {
        System.out.println("Enter Booking ID: ");
        int cancelID = scanner.nextInt();
        bookingController.cancelBooking(cancelID);
    }

    public void showMyBookings() {
        bookingController.showMyBookings();
    }
}
