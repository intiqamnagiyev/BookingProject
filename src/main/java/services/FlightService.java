package services;

import dao.Dao;
import dao.FlightDao;
import model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class FlightService {
    private Dao<Flight> flightDao = new FlightDao();

    public List<Flight> getAll() {
        return flightDao.getAll();
    }

    public Flight getById(int id) {
        return flightDao.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight cannot found!"));
    }

    public List<Flight> search(Flight flight) {

        return flightDao.getAll()
                .stream()
                .filter(flight1 -> flight1.getTo().name().equals(flight.getTo().name()))
                .collect(Collectors.toList());
    }

    public void loadData() {
        flightDao.loadData();
    }

    public void save(Flight flight) {
        flightDao.save(flight);
    }
}
