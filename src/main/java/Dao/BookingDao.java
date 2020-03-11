package Dao;

import model.Booking;
import model.Database;
import model.Passanger;
import model.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BookingDao implements Dao<Booking> {

    private Database database = new Database();

    @Override
    public List<Booking> getAll() {
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
    public boolean delete(int id) {
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


    public Booking makeBooking(int tickets) {
        List<Passanger> passengers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter flight ID: ");
        int id = scanner.nextInt();
        for (int i = 0; i < tickets; i++) {
            System.out.println("Enter Passenger name and surname: ");
            String name = scanner.next();
            passengers.add(new Passanger(name));
        }
        return new Booking(Session.getUser(), id, passengers);
    }
}
