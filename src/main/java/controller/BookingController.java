package controller;

import model.Booking;
import model.Flight;
import model.Passenger;
import services.BookingService;

import java.util.List;
import java.util.stream.Collectors;

public class BookingController {

    private BookingService bookingService = new BookingService();

    public void makeBooking(Flight flight, List<Passenger> passengers)  {

        if (bookingService.makeBooking(flight, passengers)) {
            System.out.println("You have made new booking!");
        } else {
            System.out.println("Something went wrong, please try again!");
        }
    }

    public void showMyBookings() {
        if (bookingService.getAllBookings().isEmpty()) {
            System.out.println("Your booking list is empty!");
        } else {
        bookingService.getAllBookings().stream()
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

    public void cancelBooking(int cancelId) {
        bookingService.cancelBooking(cancelId);
    }

    public void loadData() {
        bookingService.loadData();
    }
}
