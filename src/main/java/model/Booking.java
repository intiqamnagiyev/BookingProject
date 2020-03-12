package model;

import java.io.*;
import java.util.List;

public class Booking implements Serializable {
    private User user;
    private int id;
    private Flight flight;
    private List<Passanger> passengerList;


    public Booking(int id,User user, Flight flight, List<Passanger> passengerList) {
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

    public List<Passanger> getPassengerList() {
        return passengerList;
    }

    @Override
    public String toString() {
        //
        //PassangerList:%-12s
        return String.format("Booking ID:%-3d Flight:%s \nPassengerlist: ", id, flight);
    }


}
