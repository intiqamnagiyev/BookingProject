package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Inputs {
    Scanner scanner = new Scanner(System.in);

    public int inputId() {
        System.out.println("Enter flight ID: ");
        int id = scanner.nextInt();
        return id;
    }
    public String inputPassengerName(){
        System.out.println("Enter Passenger name : ");
        String name = scanner.next();
        return name;
    }
    public String inputPassengerSurname(){
        System.out.println("Enter Passenger Surname : ");
        String surname = scanner.next();
        return surname;
    }
    public String inputUsername(){
        System.out.println("Username:");
        String username = scanner.next();
        return username;
    }
    public String inputPssword(){
        System.out.println("Password:");
        String password = scanner.next();
        return password;
    }
    public String inputCity(){
        System.out.println("Enter destination city: ");
        String city = scanner.next().toUpperCase();
        return city;
    }
    public LocalDate inputDate(){
        System.out.println("Enter date(like YYYY-MM-DD):");
        LocalDate date = LocalDate.parse(scanner.next());
        return date;
    }
    public int inputTickets(){
        System.out.println("Enter number of tickets: ");
        int tickets = scanner.nextInt();
        return tickets;
    }
    public int inputCancelId(){
        System.out.println("Enter Booking ID: ");
        int cancelID = scanner.nextInt();
        return cancelID;
    }


}
