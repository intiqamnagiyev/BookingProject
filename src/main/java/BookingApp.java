import menu.MenuOperation;
import menu.ShowMenu;

import java.util.Scanner;

public class BookingApp {

    private MenuOperation menuOperation = new MenuOperation();
    private ShowMenu showMenu = new ShowMenu();

    public void run() {
        menuOperation.loadData();
        Scanner scanner = new Scanner(System.in);

        boolean flag0 = true;
        while (flag0) {
            boolean flag1 = false;
            showMenu.menu0();
            String menu0item = scanner.next();
            switch (menu0item) {
                case "1":flag1 = menuOperation.getUser();break;
                case "2":menuOperation.createNewUser();break;
                case "3":flag0 = menuOperation.exitMenu0();break;
                default:menuOperation.invalidMenuItem();break;
            }
            while (flag1) {
                showMenu.menu1();
                String menuItem = scanner.next();
                switch (menuItem) {
                    case "1":menuOperation.getAllFlights();break;
                    case "2":menuOperation.getFlightById();break;
                    case "3":boolean flag2 = menuOperation.searchFlightsForBooking();
                    while (flag2) {
                            showMenu.menu2();
                            String press = scanner.next();
                            switch (press) {
                                case "1":menuOperation.makeBooking();break;
                                case "2":flag2 = false;break;
                                default:menuOperation.invalidMenuItem();break;
                            }
                        }
                        break;
                    case "4":menuOperation.cancelBooking();break;
                    case "5":menuOperation.showMyBookings();break;
                    case "6":
                        menuOperation.exit();flag1 = false;break;
                    default:menuOperation.invalidMenuItem();break;
                }
            }
        }
    }
}