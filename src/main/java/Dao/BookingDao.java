package Dao;

import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingDao implements Dao<Booking> {

    private Database database = new Database();
    private Inputs inputs = new Inputs();

    @Override
    public List<Booking> getAll() throws IOException, ClassNotFoundException {
        return database.getAllBookings();
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
    public boolean create(Booking booking) {
        database.getBookingList().add(booking);
        return database.writeToFileBooking();
    }

    @Override
    public boolean delete(int id) throws IOException, ClassNotFoundException {
        List<Booking> collect = database.getAllBookings()
                .stream().filter(booking -> booking.getId() == id)
                .collect(Collectors.toList());
        database.getBookingList().removeAll(collect);
        return database.writeToFileBooking();

    }

    @Override
    public Booking update(Booking booking) {

        return null;
    }


    public Booking makeBooking(int tickets,int flightid) throws IOException, ClassNotFoundException {
        List<Passanger> passengers = new ArrayList<>();
        int id = inputs.inputId();
        for (int i = 0; i < tickets; i++) {
            passengers.add(new Passanger(inputs.inputPassengerName(),inputs.inputPassengerSurname()));
        }
        return new Booking(++flightid,Session.getUser(),
                database.getAllFlights().stream()
                        .filter(flight -> flight.getId()==id)
                        .findAny()
                        .orElseThrow(RuntimeException::new),
                passengers);
    }
}
