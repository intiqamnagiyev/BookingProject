package services;

import Dao.BookingDao;
import Dao.UserDao;
import model.Booking;
import model.Flight;
import model.Passanger;
import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
//
//class BookingServiceTest {
//    BookingService bookingService = new BookingService();
//    UserDao userDao = new UserDao();
//    Booking booking = new Booking(new User("User","123"),(new Flight()), Arrays.asList(new Passanger("Passengername","Passangersurname"));
//
//
//    @Test
//    void TestForMakeBooking() {
//       assertTrue(bookingService.makeBooking());
//    }
//
//    @Test
//    void TestForShowMyBookings() {
//        bookingDao.create(booking);
//        assertTrue(s);
//
//    }
//
//    @Test
//    void cancelBooking() {
//    }
//}