package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Passanger implements Serializable {
    private String nameSurname;

    public Passanger(String name) {
        this.nameSurname = name;
    }


    @Override
    public String toString() {
        return String.format("Passanger:nameSurname= %s}", nameSurname);
    }
}
