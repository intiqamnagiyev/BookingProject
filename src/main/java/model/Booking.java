package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Serializable {
    private int id;
    private int flightID;
    private List<Passanger> passangerList;
    static int count=0;

    public Booking(int flightID, List<Passanger> passangerList) {
        this.id = ++count;
        this.flightID = flightID;
        this.passangerList = passangerList;
    }

    public int getId() {

        return id;
    }

    @Override
    public String toString() {
        return String.format("Booking ID:%-3d Flight ID:%-3d PassangerList:%-12s ", id, flightID, passangerList);
    }
}
