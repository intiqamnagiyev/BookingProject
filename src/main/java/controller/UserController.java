package controller;

import model.Session;
import model.User;
import services.UserService;

public class UserController {
    private UserService userService = new UserService();

    public void getUser(User user) {
        try {
            User user1 = userService.getUser(user);
            Session.setUser(user1);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    public void creatNewUser(User user) {
        if (userService.createNewUser(user)) {
            System.out.println("Succesfully signed up, please login.");
        } else {
            System.out.println("Something went wrong! Sign up again.");
        }
    }
}
