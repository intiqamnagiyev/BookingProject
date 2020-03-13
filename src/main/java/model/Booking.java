package model;

import java.io.*;
import java.util.List;

public class Booking implements Serializable {
    private User user;
    private int id;
    private Flight flight;
    private List<Passenger> passengerList;
    static int count = 0;

    public Booking(int id,User user, Flight flight, List<Passenger> passengerList) {
        this.user = user;
        this.id = id;
        this.flight = flight;
        this.passengerList = passengerList;
    }

    public int getId() {

        return id;
    }

    public User getUser() {
        return user;
    }

    public Flight getFlight() {
        return flight;
    }

    public List<Passenger> getPassengerList() {
        return passengerList;
    }

    @Override
    public String toString() {
        return String.format("Booking ID:%-3d Flight:%s \nPassengerlist: ", id, flight);
    }


}
