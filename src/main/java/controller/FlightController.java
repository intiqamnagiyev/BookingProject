package controller;

import model.Flight;

import services.FlightService;

import java.io.IOException;

public class FlightController {

    private FlightService flightService = new FlightService();

    public void getAll()  {
        try {
            flightService.getAll().forEach(System.out::println);
        }catch (Exception e){
            System.out.println("flight list is empty");
        }
    }

    public void end() {
    }

    public void getById(int id)  {
        try {
            System.out.println(flightService.getById(id));
        } catch (Exception e) {
            System.out.println("flight hasn't found");
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
