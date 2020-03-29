package services;

import model.City;
import model.Flight;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
        private  static FlightService flightService = new FlightService();
        private static Flight flight;
        @BeforeAll
        static void beforeAll(){
            flight=new Flight(
                    1,
                    City.randCity(),
                    City.randCity(),
                    LocalDate.now(),
                    LocalTime.now().plusHours((long) (Math.random() * 10))
                            .plusMinutes((long) (Math.random() * 10))
                            .truncatedTo(ChronoUnit.SECONDS),
                    (int) (Math.random() * 100));
           flightService.save(flight);
        }

        @Test
        void getAllTest() {
            assertFalse(flightService.getAll().isEmpty());
        }

        @Test
        void getByIdTest() {
            assertTrue(flightService.getAll().contains(flightService.getById(1)));

        }

        @Test
        void searchTest()  {
            Flight flight = new Flight(City.MOSCOW, LocalDate.now().minusDays(2));
            assertEquals(0,flightService.search(flight).size());
        }

}