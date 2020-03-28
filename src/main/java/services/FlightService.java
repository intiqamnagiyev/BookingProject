package services;

import dao.Dao;
import dao.FlightDao;
import model.Flight;

import java.io.IOException;
import java.util.List;

public class FlightService {
    private Dao<Flight> flightDao = new FlightDao();

    public List<Flight> getAll()  {
        return flightDao.getAll();
    }

    public Flight getById(int id) throws IOException, ClassNotFoundException {
        return flightDao.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight cannot found!"));
    }

    public Flight search(Flight flight) throws IOException, ClassNotFoundException {
        return flightDao.get(flight)
                .orElseThrow(() -> new IllegalArgumentException("Flight can't found!"));
    }

    public void loadData() {
        flightDao.loadData();
    }
}
