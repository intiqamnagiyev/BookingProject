package controller;

import model.Booking;
import model.Passenger;
import services.BookingService;

import java.io.IOException;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {
    private BookingService bookingService = new BookingService();

    public void makeBooking(int flightId, List<Passenger> passengers)  {

        try {
            if (bookingService.makeBooking(flightId,passengers)) {
                System.out.println("You have made new booking!");
            } else {
                System.out.println("Something went wrong, please try again!");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error occurred while create booking");
        }
    }

    public void showMyBookings() {
        if (bookingService.showMyBookings().isEmpty()) {
            System.out.println("Your booking list is empty!");
        } else {
        bookingService.showMyBookings().stream()
                    .collect(Collectors.toMap(booking -> booking, Booking::getPassengerList))
                     .keySet().forEach(booking -> {
                 System.out.printf("Booking ID:%-3d Flight ID:%-12s\nPassenger List :\n -------------------------------------\n", booking.getId(),booking.getFlight());
                 booking.getPassengerList()
                         .forEach(passenger ->
                                 System.out.printf("|Name=%-10s| Surname=%-10s|\n-------------------------------------\n",
                                         passenger.getName(),passenger.getSurname()));
                     }
             );

        }
    }

    public void cancelBooking(int cancelID) {
        bookingService.cancelBooking(cancelID);
    }
}
