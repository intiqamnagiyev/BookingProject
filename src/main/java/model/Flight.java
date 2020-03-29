package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Flight implements Serializable {
    private int id;
    private City from;
    private City to;
    private LocalDate date;
    private LocalTime time;
    private int seats;
    private static int count = 0;


    public Flight() {
    }

    public Flight(int id, City from, City to, LocalDate date, LocalTime time, int seats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.seats = seats;
        this.time = time;
    }

    public Flight(City to, LocalDate date) {
        this.to = to;
        this.date = date;
    }

    public static List<Flight> createSchedule() {
        List<Flight> scList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Flight flight = new Flight(
                    ++count,
                    City.randCity(),
                    City.randCity(),
                    LocalDate.now(),
                    LocalTime.now().plusHours((long) (Math.random() * 10))
                            .plusMinutes((long) (Math.random() * 10))
                            .truncatedTo(ChronoUnit.SECONDS),
                    (int) (Math.random() * 100));
            scList.add(flight);
        }
        return scList;
    }



    public int getId() {
        return id;
    }

    public City getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                to == flight.to &&
                Objects.equals(date, flight.date) &&
                Objects.equals(time, flight.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, from, to, date, time, seats);
    }

    @Override
    public String toString() {
        return String.format("ID:%-4d  Fly from   %-12s  (%-4s) to %-12s  (%-4s)  on day: %-10s  at: %-10s  there are only %d seats", id, from.name(), from.getCode(), to.name(), to.getCode(), date.toString(), time.toString(), seats);
    }

}
