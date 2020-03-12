package controller;

import model.Booking;
import model.Passanger;
import services.BookingService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
//            bookingService.showMyBookings().forEach(System.out::println);
           /* bookingService.showMyBookings().forEach(booking ->
                    booking.getPassangerList().stream().forEach(passanger ->
                            System.out.printf("Booking ID:%-3d Flight:%s \nPassengerlist:\n Name: %-10s Surname:%-10s\n ",
                                    booking.getId(), booking.getFlight(),passanger.getName(),passanger.getSurname()))
                    );*/
            List<Booking> bookings = bookingService.showMyBookings();

            Map<Booking, List<Passanger>> collect = bookingService.showMyBookings()
                    .stream().collect(Collectors.toMap(booking -> booking, Booking::getPassangerList));
            System.out.println("mapss"+collect);
                       // collect.keySet().stream().forEach(k-> System.out.printf("Booking ID:%-3d Flight:%s \nPassengerlist:%s\n",k.getId(),k.getFlight(),k.getPassangerList()));

            int term = 0;
            /*for(Passanger passanger : collect) {
                System.out.printf("%-2d Name:%-10s Surname:%-14s \n" , ++term,passanger.getName(),passanger.getSurname());
            }*/

            for (Booking booking:bookings){
                System.out.printf("Booking ID:%-3d Flight:%s \nPassengerlist:\n",booking.getId(), booking.getFlight());
                for (Passanger passanger:collect.getOrDefault(booking,new ArrayList<>())){
                    System.out.printf("Name: %-10s Surname:%-10s\n ",
                                                            passanger.getName(),passanger.getSurname());
                }
            }
        }
    }

    public void cancelBooking(int cancelID) {
        bookingService.cancelBooking(cancelID);
    }
}
