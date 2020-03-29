package services;

import dao.BookingDao;
import dao.Dao;
import model.Booking;
import model.Flight;
import model.Passenger;
import model.Session;

import java.util.Comparator;
import java.util.List;

public class BookingService {
    private Dao<Booking> bookingDao = new BookingDao();


    public boolean makeBooking(Flight flight, List<Passenger> passengers) {
        int lastBookingId = getLastBookingId();
        Booking booking = new Booking(++lastBookingId, Session.getUser(), flight, passengers);
        return bookingDao.save(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingDao.getAll();
    }

    public void cancelBooking(int cancelId) {
        try {
            bookingDao.delete(cancelId);
        } catch (Exception e) {
            System.out.println("May be there is no such Booking with id: " + cancelId);
        }
    }

    public int getLastBookingId() {
        return bookingDao.getAll().stream()
                .max(Comparator.comparingInt(Booking::getId))
                .map(Booking::getId).orElse(0);


    }

    public void loadData() {
        bookingDao.loadData();
    }
}
