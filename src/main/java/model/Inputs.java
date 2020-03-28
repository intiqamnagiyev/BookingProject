package model;

import java.time.LocalDate;
import java.util.Scanner;

public class Inputs {
    Scanner scanner = new Scanner(System.in);

    public int inputId() {
        int flightId=0;
        while (true){
            System.out.println("Enter flight ID: ");
            Scanner scanner1 =new Scanner(System.in);
            try {
                flightId=scanner1.nextInt();
                break;
            }catch (Exception e){
                System.out.println("invalid flightId, Again pls.");
            }
        }
        return flightId;
    }
    public String inputPassengerName(){
        System.out.println("Enter Passenger name : ");
        return scanner.next();
    }
    public String inputPassengerSurname(){
        System.out.println("Enter Passenger Surname : ");
        return scanner.next();
    }
    public String inputUsername(){
        System.out.println("Username:");
        return scanner.next();
    }
    public String inputPassword(){
        System.out.println("Password:");
        return scanner.next();
    }
    public String inputCity(){
        System.out.println("Enter destination city: ");
        return scanner.next().toUpperCase();
    }
    public LocalDate inputDate(){
        System.out.println("Enter date(like YYYY-MM-DD):");
        return LocalDate.parse(scanner.next());
    }
    public int inputTickets(){
        System.out.println("Enter number of tickets: ");
        return scanner.nextInt();
    }
    public int inputCancelId(){
        System.out.println("Enter Booking ID: ");
        return scanner.nextInt();
    }


}
