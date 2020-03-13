package Dao;

import model.Booking;
import model.Database;
import model.Passenger;
import model.Session;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class BookingDao implements Dao<Booking> {
    private Database database = new Database();

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


    public Booking makeBooking(int lastBookingId, int reqFlId,List<Passenger> passengers) throws IOException, ClassNotFoundException {

        return new Booking(++lastBookingId,Session.getUser(),
                database.getAllFlights().stream()
                        .filter(flight -> flight.getId()==reqFlId)
                        .findAny()
                        .orElseThrow(RuntimeException::new),
                passengers);
    }
}
