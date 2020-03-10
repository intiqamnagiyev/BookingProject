package controller;

import model.User;
import services.UserService;

public class UserController {
    private UserService userService =new UserService();
    public void getUser(User user) {
        userService.getUser(user);
    }

    public void creatNewUser(User user) {
        userService.createNewUser(user);
    }
}
