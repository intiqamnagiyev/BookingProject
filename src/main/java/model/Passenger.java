package model;

import java.io.Serializable;

public class Passenger implements Serializable {
    private String name;
    private String surname;

    public Passenger(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return String.format(" Name:%-10s Surname:%-10s\n", name, surname);
    }
}
