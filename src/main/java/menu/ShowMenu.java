package menu;

public class ShowMenu {
    public void menu1() {
        StringBuilder sb = new StringBuilder();
        sb.append("=================================================\n");
        sb.append("|                  BOOKING APP                  |\n");
        sb.append("=================================================\n");
        sb.append("|   1. Online Board.                            |\n");
        sb.append("|   2. Show the flight info.                    |\n");
        sb.append("|   3. Search and book a flight.                |\n");
        sb.append("|   4. Cancel the booking.                      |\n");
        sb.append("|   5. My flights.                              |\n");
        sb.append("|   6. Exit                                     |\n");
        sb.append("=================================================\n");
        System.out.println(sb);
    }

    public void menu2() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("==================================================\n");
        sb2.append("|                       MENU                     |\n");
        sb2.append("==================================================\n");
        sb2.append("|   1. Booking.                                  |\n");
        sb2.append("|   2. Return main menu         .                |\n");
        sb2.append("==================================================\n");
        System.out.println(sb2);
    }

    public void menu0() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("==================================================\n");
        sb2.append("|                       MENU                      |\n");
        sb2.append("==================================================\n");
        sb2.append("|   1. Log In.                                    |\n");
        sb2.append("|   2. Sign Up.                                   |\n");
        sb2.append("|   3. Exit.                                      |\n");
        sb2.append("==================================================\n");
        System.out.println(sb2);
    }
}
