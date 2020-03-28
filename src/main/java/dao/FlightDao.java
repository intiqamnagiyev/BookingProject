package dao;

import model.Flight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FlightDao implements Dao<Flight> {
    private List<Flight> flights = new ArrayList<>();

    @Override
    public List<Flight> getAll() {
        return flights;
    }

    @Override
    public Optional<Flight> get(Flight flight) {
        return flights.stream()
                .filter(flight1 -> flight1.getTo().name().equals(flight.getTo().name()) && flight1.getDate().equals(flight.getDate()))
                .findAny();
    }

    @Override
    public Optional<Flight> getById(int id) {
        return flights
                .stream()
                .filter(flight -> flight.getId() == id)
                .findAny();
    }


    @Override
    public boolean save(Flight flight) {
//        List<Flight> flightList = database.getFlightList();
//        flightList.add(flight);
//        database.write(flightList);
        return true;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public Flight update(Flight flight) {
        return null;
    }

    public void writeToFile() {
        try {
            File file = new File("Schedule.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flights);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File cannot found!");
        }
    }

    @Override
    public void loadData() {
        flights = Flight.createSchedule();
        writeToFile();
        try {
            File file = new File("Schedule.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            flights = (List<Flight>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            System.out.println();
        }
    }


}
