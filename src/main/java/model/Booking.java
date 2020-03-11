package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Serializable {
    private User user;
    private int id;
    private int flightID;
    private List<Passanger> passangerList;
    static int count = 0;

    public Booking(User user, int flightID, List<Passanger> passangerList) {
        this.user = user;
        this.id = ++count;
        this.flightID = flightID;
        this.passangerList = passangerList;
    }

    public int getId() {

        return id;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return String.format("Booking ID:%-3d Flight ID:%-3d PassangerList:%-12s ", id, flightID, passangerList);
    }
}
