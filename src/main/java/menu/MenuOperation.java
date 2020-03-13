package menu;

import controller.BookingController;
import controller.FlightController;
import controller.UserController;
import model.City;
import model.Flight;
import model.Inputs;
import model.User;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuOperation {
    private BookingController bookingController = new BookingController();
    private FlightController flightController = new FlightController();
    private UserController userController = new UserController();
    Inputs inputs = new Inputs();

    public boolean getUser() {
        try {
            userController.getUser(new User(inputs.inputUsername(), inputs.inputPssword()));
            return true;
        } catch (Exception e) {
            System.out.println("User doesn't exist, please sign up!");
            return false;
        }
    }

    public void createNewUser() {
        userController.creatNewUser(new User(inputs.inputUsername(), inputs.inputPssword()));
    }

    public void getAllFlights() {
        flightController.getAll();
    }

    public void getFlightById() {
        flightController.getById(inputs.inputId());
    }

    public boolean searchFligtsForBooking() {
        try {
            flightController.search(new Flight(City.valueOf(inputs.inputCity()), inputs.inputDate()));
            return true;
        } catch (IllegalArgumentException im) {
            System.out.println("Such city hasn't found");
            return false;
        } catch (DateTimeParseException dtpe) {
            System.out.println("Invalid date format, please enter data YYYY-MM-DD format");
            return false;
        } catch (Exception ex) {
            System.out.println("Date format is not true!");
            return false;
        }
    }

    public void makeBooking() {
        boolean validate = true;
        while (validate) {
            int tickets = inputs.inputTickets();
            if (tickets > 0) {
                bookingController.makeBooking(tickets);
                validate = false;
            } else {
                System.out.println("Ticket count has to be at least 1!");
            }
        }
    }

    public void cancelBooking() {
        bookingController.cancelBooking(inputs.inputCancelId());
    }

    public void showMyBookings() {
        bookingController.showMyBookings();
    }
}
