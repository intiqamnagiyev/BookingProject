package controller;

import services.BookingService;

import java.io.IOException;

public class BookingController {
    private BookingService bookingService = new BookingService();

    public void makeBooking(int tickets) {
        if (bookingService.makeBooking(tickets)) {
            System.out.println("You have made new booking!");
        } else {
            System.out.println("Something went wrong, please try again");
        }
    }

    public void showMyBookings() {
        if (bookingService.showMyBookings().isEmpty()) {
            System.out.println("your booking list is empty");
        } else {
            bookingService.showMyBookings().forEach(System.out::println);
        }
    }

    public void cancelBooking(int cancelID) {
        bookingService.cancelBooking(cancelID);
    }
}
