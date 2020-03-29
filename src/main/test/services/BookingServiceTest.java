package services;

import model.Flight;
import model.Passenger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    private  static  BookingService bookingService = new BookingService();
    static Flight flight = new Flight();
    static List<Passenger> psLst = new ArrayList<>();

     @BeforeAll
     static void beforeAll(){
         bookingService.makeBooking(flight,psLst);
     }

    @Test
    void makeBookingTest() {
        assertTrue(bookingService.makeBooking(flight,psLst));
    }

    @Test
    void loadDataTest() {
        bookingService.loadData();
      assertFalse(bookingService.getAllBookings().isEmpty());
    }

    @Test
    void getAllBookingsTest() {
        assertFalse(bookingService.getAllBookings().isEmpty());
    }

    @Test
    void cancelBookingTest() {
        bookingService.cancelBooking(1);
        assertEquals(1,bookingService.getAllBookings().size());
    }

    @Test
    void getLastBookingIdTest() {
        assertEquals(2,bookingService.getLastBookingId());
    }
}