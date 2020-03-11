package services;

import Dao.FlightDao;
import model.Flight;

import java.io.IOException;
import java.util.List;

public class FlightService {
    private FlightDao flightDao = new FlightDao();

    public List<Flight> getAll() throws IOException, ClassNotFoundException {
        return flightDao.getAll();
    }

    public Flight getById(int id) throws IOException, ClassNotFoundException {
        return flightDao.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight cannot found!"));
    }

    public Flight search(Flight flight) throws IOException, ClassNotFoundException {
        return flightDao.get(flight)
                .orElseThrow(() -> new IllegalArgumentException("flight not found"));
    }
}
