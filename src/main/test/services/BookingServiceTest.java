package services;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {
    BookingService bookingService = new BookingService();

    @Test
    void makeBooking() {
    }

    @Test
    void testShowMyBookings() throws IOException, ClassNotFoundException {
        bookingService.makeBooking(2);
        assertFalse(bookingService.showMyBookings().isEmpty());
    }

    @Test
    void testCancelBooking() {

    }

    @Test
    void testGetLastBookingId() {
    }
}