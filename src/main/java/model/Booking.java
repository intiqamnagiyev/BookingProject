package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Booking implements Serializable {
    private User user;
    private int id;
    private Flight flight;
    private List<Passanger> passangerList;
    static int count = 0;

    public Booking(int id,User user, Flight flight, List<Passanger> passangerList) {
        this.user = user;
        this.id = id;
        this.flight = flight;
        this.passangerList = passangerList;
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

    public List<Passanger> getPassangerList() {
        return passangerList;
    }

    @Override
    public String toString() {
        //
        //PassangerList:%-12s
        return String.format("Booking ID:%-3d Flight:%s \nPassengerlist: ", id, flight);
    }


}
