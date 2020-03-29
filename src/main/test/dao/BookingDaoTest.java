package dao;

import model.Booking;
import model.Flight;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BookingDaoTest {
    private BookingDao bookingDao;
    private Booking booking;

    @BeforeEach
    void init() {//1
        bookingDao = new BookingDao();
        booking = new Booking(1, new User("john", "12345"), new Flight(), new ArrayList<>());
        bookingDao.save(booking);
    }

    @Test
    void getAllTest() {
        assertFalse(bookingDao.getAll().isEmpty());
    }


    @Test
    void saveTest() {
        Booking booking = new Booking(2, new User("john", "12345"), new Flight(), new ArrayList<>());//thank u:)
        assertTrue(bookingDao.save(booking));//2
    }

    @Test
    void deleteTest() {
        bookingDao.delete(1);
        assertEquals(0, bookingDao.getAll().size());
    }


    @Test
    void loadDataTest() {
        bookingDao.loadData();
        assertFalse(bookingDao.getAll().isEmpty());
    }

    @Test
    void writeToFileBookingTest() {
        assertTrue(bookingDao.writeToFileBooking());
    }
}