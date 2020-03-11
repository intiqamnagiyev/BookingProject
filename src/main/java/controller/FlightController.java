package controller;

import model.Flight;

import services.FlightService;

import java.io.IOException;

public class FlightController {

    private FlightService flightService = new FlightService();

    public void getAll() {
        try {
            flightService.getAll().forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Flight list is empty!");
        }
    }

    public void getById(int id) {
        try {
            System.out.println(flightService.getById(id));
        } catch (Exception e) {
            System.out.println("Flight hasn't found!");
        }
    }
    public void search(Flight flight) {
        try {
            Flight search = flightService.search(flight);
            System.out.println(search);
        } catch (Exception e) {
            System.out.println("Flight can't found!");
        }

    }
}
