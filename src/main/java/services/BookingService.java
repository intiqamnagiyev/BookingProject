package services;
import Dao.BookingDao;
import model.Booking;
import model.Session;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private BookingDao bookingDao = new BookingDao();


    public boolean makeBooking(int tickets) throws IOException, ClassNotFoundException {

        return bookingDao.create(bookingDao.makeBooking(tickets,getLastBookingId()));
    }

    public List<Booking> showMyBookings() {
        List<Booking> collect=new ArrayList<>();
        try {
         collect = bookingDao.getAll()
                    .stream()
                    .filter(booking -> booking.getUser().equals(Session.getUser()))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            System.out.println("");
        }
        return collect;
    }

    public void cancelBooking(int cancelID)  {
        try {
            bookingDao.delete(cancelID);
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
    public int getLastBookingId()  {
        return showMyBookings().stream()
                .max(Comparator.comparingInt(Booking::getId))
                .map(Booking::getId).orElse(0);



    }

}
