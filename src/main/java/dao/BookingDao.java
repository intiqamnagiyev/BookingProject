package dao;

import model.Booking;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookingDao implements Dao<Booking> {
    private List<Booking> bookings = new ArrayList<>();


    @Override
    public List<Booking> getAll() {
        return bookings;
    }

    @Override
    public Optional<Booking> get(Booking booking) {
        return Optional.empty();
    }

    @Override
    public Optional<Booking> getById(int id) {

        return Optional.empty();
    }

    @Override
    public boolean save(Booking booking) {
        bookings.add(booking);
        return writeToFileBooking();
    }

    @Override
    public boolean delete(int id) {
        bookings.removeIf(booking -> booking.getId() == id);
        return writeToFileBooking();

    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("src\\main\\java\\file\\Booking.txt")))) {
            bookings = (List<Booking>) ois.readObject();

        } catch (Exception e) {
            System.out.println();
        }
    }

    public boolean writeToFileBooking() {
        try {
            File file = new File("src\\main\\java\\file\\Booking.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bookings);
            oos.close();
            fos.close();
            return true;
        } catch (Exception io) {
            System.out.println();
            return false;
        }
    }

}
