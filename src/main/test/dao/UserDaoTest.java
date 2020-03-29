package dao;

import model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private UserDao userDao;
    private User user;

    @BeforeEach
    void inti() {
        userDao = new UserDao();
         user = new User("user", "psswrd");
        userDao.save(user);
    }


    @Test
    void getAllTest() {
        assertFalse(userDao.getAll().isEmpty());
    }

    @Test
    void getTest() {
        assertEquals(Optional.of(new User("user", "psswrd")),
                userDao.get(new User("user", "psswrd")));
    }


    @Test
    void loadDataTest() {
        userDao.loadData();
        assertFalse(userDao.getAll().isEmpty());
    }

    @Test
    void writeToFileUserTest() {
        assertTrue(userDao.writeToFileUser());
    }
}