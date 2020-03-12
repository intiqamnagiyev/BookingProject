package menu;

import java.util.LinkedHashMap;
import java.util.Map;

public class MenuItem {
    public static void showMenu0(){
        Map<String, String> menuItems=new LinkedHashMap<>();
        menuItems.put("1."," Log in");
        menuItems.put("2."," Sign up");
        menuItems.put("3."," Exit");
        menuItems.keySet()
                .forEach(k-> System.out.println(k+" "+menuItems.get(k)));


    }
    public static void showMenu1(){
        Map<String, String> menuItems=new LinkedHashMap<>();
        menuItems.put("1."," Online Board.");
        menuItems.put("2."," Show the flight info.");
        menuItems.put("3."," Search and book a flight.");
        menuItems.put("4."," Cancel the booking.");
        menuItems.put("5."," My flights.");
        menuItems.put("6."," Exit");
        menuItems.keySet()
                .forEach(k-> System.out.println(k+" "+menuItems.get(k)));
    }


}
