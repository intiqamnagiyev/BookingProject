package model;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Flight implements Serializable {
    private int id;
    private City from;
    private City to;
    private LocalDate date;
    private LocalTime time;
    private int seats;
    private static int count = 0;
    static List<Flight> scList = new ArrayList<>();

    private Flight(int id, City from, City to, LocalDate date, LocalTime time, int seats) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.date = date;
        this.seats = seats;
        this.time= time;
    }
    public static void createSchedule() throws IOException {
        for (int i = 0; i < 30; i++) {
            Flight flight = new Flight(
                    ++count,
                    City.randCity(),
                    City.randCity(),
                    LocalDate.now(),
                    LocalTime.now().plusHours((long) (Math.random()*10)).plusMinutes((long) (Math.random()*10)).truncatedTo(ChronoUnit.SECONDS),
                    (int) (Math.random() * 100));
            scList.add(flight);
        }
        writeToFile(scList);
    }

    public static void writeToFile(List<Flight> flights){
        try {
            File file = new File("schedule.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(flights);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("File cannot found");
        }
    }

    public Flight() {
    }

    public Flight(City to, LocalDate date) {
        this.to = to;
        this.date = date;
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

    @Override
    public String toString() {
        return String.format("ID:%-4d  Fly from   %-12s  (%-4s) to %-12s  (%-4s)  on day: %-10s  at: %-10s  there are only %d seats", id, from.name(), from.getCode(), to.name(), to.getCode(), date.toString(), time.toString(), seats);
    }

}
