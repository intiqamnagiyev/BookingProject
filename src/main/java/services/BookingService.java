package services;

import Dao.BookingDao;
import model.Booking;
import model.Session;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private BookingDao bookingDao = new BookingDao();


    public boolean makeBooking(int tickets) {
        return bookingDao.create(bookingDao.makeBooking(tickets));
    }

    public List<Booking> showMyBookings() {
        return bookingDao.getAll()
                .stream()
                .filter(booking -> booking.getUser()
                        .equals(Session.getUser()))
                .collect(Collectors.toList());
    }

    public void cancelBooking(int cancelID) throws IOException, ClassNotFoundException {
        bookingDao.delete(cancelID);
    }
}
