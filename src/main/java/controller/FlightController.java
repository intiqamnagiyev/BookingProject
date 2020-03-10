package controller;

import model.Flight;

import services.FlightService;

import java.io.IOException;

public class FlightController {

    private FlightService flightService = new FlightService();

    public void getAll() throws IOException, ClassNotFoundException {
        flightService.getAll().forEach(System.out::println);
    }

    public void end() {
    }

    public void getById(int id) throws IOException, ClassNotFoundException {
        try {
            System.out.println(flightService.getById(id));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public void search(Flight flight) throws IOException, ClassNotFoundException {
        try {
            Flight search = flightService.search(flight);
            System.out.println(search);
        } catch (Exception e) {
            System.out.println("flight hasn't fount");
        }

    }
}
