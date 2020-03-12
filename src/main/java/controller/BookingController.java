package controller;

import model.Booking;
import services.BookingService;

import java.io.IOException;

import java.util.stream.Collectors;

public class BookingController {
    private BookingService bookingService = new BookingService();

    public void makeBooking(int tickets) throws IOException, ClassNotFoundException {

        if (bookingService.makeBooking(tickets)) {
            System.out.println("You have made new booking!");
        } else {
            System.out.println("Something went wrong, please try again!");
        }
    }

    public void showMyBookings() {
        if (bookingService.showMyBookings().isEmpty()) {
            System.out.println("Your booking list is empty!");
        } else {
        bookingService.showMyBookings().stream()
                    .collect(Collectors.toMap(booking -> booking, Booking::getPassangerList))
                     .keySet().forEach(booking -> {
                 System.out.printf("Booking ID:%-3d Flight ID:%-12s\n", booking.getId(),booking.getFlight());
                 booking.getPassangerList()
                         .forEach(passanger ->
                                 System.out.printf("Name=%-10s, Surname=%-10s\n",
                                         passanger.getName(),passanger.getSurname()));
                     }
             );

        }
    }

    public void cancelBooking(int cancelID) {
        bookingService.cancelBooking(cancelID);
    }
}
