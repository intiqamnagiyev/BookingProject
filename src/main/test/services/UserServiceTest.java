package services;

import model.User;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserServiceTest {
    private static UserService userService = new UserService();
    private static  User user = new User("user","password");

    @BeforeAll
    static void beforeAll(){
        userService.createNewUser(user);
    }

    @Test
    void createNewUserTest(){
        assertTrue(userService.createNewUser(user));
    }

    @Test
    void getUserTest() {
        assertEquals(user,userService.getUser(user));
    }


    @Test
    void loadDataTest() {
        userService.loadData();
        assertEquals(user,userService.getUser(user));
    }
}