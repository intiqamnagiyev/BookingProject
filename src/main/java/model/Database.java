package model;

import java.io.*;
import java.util.*;


public class Database implements Serializable {


    private List<Flight> flightList = new ArrayList<>();
    private List<Booking> bookingList = new ArrayList<>();
    private List<User> userlist = new ArrayList<>();

    public List<Flight> readFromFileFlights() throws IOException, ClassNotFoundException {
        File file = new File("Schedule.txt");
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        flightList = (List<Flight>) ois.readObject();
        ois.close();
        fis.close();
        return flightList;
    }

    public List<Booking> readFromFileMyBookings() throws IOException, ClassNotFoundException {

            File file = new File("Booking.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            bookingList = (List<Booking>) ois.readObject();
            ois.close();
            fis.close();


        return bookingList;
    }

    public boolean writeToFileBooking() {
        try {
            File file = new File("Booking.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookingList);
            oos.close();
            fos.close();
            return true;
        } catch (Exception io) {
            io.printStackTrace();
            System.out.println(io.getMessage());
            throw new RuntimeException();
        }
    }

    public List<Flight> getAllFlights() throws IOException, ClassNotFoundException {
        if(flightList.isEmpty()){
            Flight.createSchedule();
        }

        flightList=readFromFileFlights();
        return flightList;
    }

    public List<Booking> getAllBookings() throws IOException, ClassNotFoundException {
        bookingList=readFromFileMyBookings();
        return bookingList;
    }
    public List<User> getUserlist() {
        return userlist;
    }


    public List<Booking> getBookingList() {
        return bookingList;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }


    public List<User> getAllUsers() {
        return readFromFileUsers();
    }

    private List<User> readFromFileUsers() {
        try {
            File file = new File("Users.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            userlist = (List<User>) ois.readObject();
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return userlist;
    }

    public boolean writeToFileUsers() {
        try {
            File file = new File("Users.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userlist);
            oos.close();
            fos.close();
            return true;
        } catch (Exception io) {
            io.printStackTrace();
            System.out.println(io.getMessage());
            throw new IllegalArgumentException("Something went wrong!");
        }
    }
}
