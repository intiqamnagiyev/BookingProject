package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passanger implements Serializable {
    private String name;
    private  String surname;

    public Passanger(String name, String surname) {
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
        return String.format(" Name:%-10s Surname:%-10s\n", name , surname);
    }
}
