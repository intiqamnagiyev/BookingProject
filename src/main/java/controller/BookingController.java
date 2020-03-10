package controller;

import services.BookingService;

import java.io.IOException;

public class BookingController {
    private BookingService bookingService=new BookingService();
    public void makeBooking(int tickets){
        if(bookingService.makeBooking(tickets)){
            System.out.println("You have made new booking!");
        }else {
            System.out.println("Something went wrong, please try again");
        }
    }

    public void showMyBookings() throws IOException, ClassNotFoundException {
        bookingService.showMyBookings().forEach(System.out::println);
    }

    public void cancelBooking(int cancelID) throws IOException, ClassNotFoundException {
        bookingService.cancelBooking(cancelID);
    }
}
