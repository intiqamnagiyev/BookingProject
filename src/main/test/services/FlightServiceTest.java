package services;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;

class FlightServiceTest {
    FlightService flightService = new FlightService();

    @Test
    void testGetAll() throws IOException, ClassNotFoundException {
        assertFalse(flightService.getAll().isEmpty());
    }

    @Test
    void testGetById() throws IOException, ClassNotFoundException {
       // assertTrue(flightService.getAll().contains(flightService.getById(1)));
    }

    @Test
    void testSearch() throws IOException, ClassNotFoundException {
     //  assertTrue(flightService.getAll().contains(flightService.search(flightService.getById(1))));
    }
}