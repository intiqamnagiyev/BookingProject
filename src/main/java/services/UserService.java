package services;

import dao.UserDao;
import model.User;

public class UserService {
    private UserDao userDao = new UserDao();

    public User getUser(User user) {
        return userDao.get(user)
                .orElseThrow(() -> new IllegalArgumentException("user hasn't found"));
    }

    public boolean createNewUser(User user) {
        return userDao.save(user);
    }

    public void loadData() {
        userDao.loadData();
    }
}
