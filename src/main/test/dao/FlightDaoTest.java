package dao;

import model.City;
import model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class FlightDaoTest {
    private  FlightDao flightDao ;
    private Flight flight;



    @BeforeEach
     void init(){
        flightDao=new FlightDao();
        flight = new Flight(1,City.ABUDHABI,City.AMSTERDAM,LocalDate.now(), LocalTime.now(),25);
    }

    @Test
    void saveTest(){
        //Flight flight1 = new Flight(City.MADRID,LocalDate.now());
        flightDao.save(flight);//2
        assertEquals(1,flightDao.getAll().size());
    }

    @Test
    void getAllTest() {
        flightDao.save(flight);
        assertFalse(flightDao.getAll().isEmpty());
    }


    @Test
    void getByIdTest() {

        assertEquals(Optional.empty(),flightDao.getById(0));
    }


}