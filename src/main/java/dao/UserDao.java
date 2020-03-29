package dao;

import model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDao implements Dao<User> {
    private List<User> users = new ArrayList<>();

    @Override
    public Optional<User> getById(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public Optional<User> get(User user) {
        return users
                .stream()
                .filter(u -> u.equals(user))
                .findAny();

    }

    @Override
    public boolean save(User user) {
        users.add(user);
        return writeToFileUser();

    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void loadData() {
        try {
            File file = new File("src\\main\\java\\file\\Users.txt");
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            users = (List<User>) ois.readObject();
        } catch (Exception e) {
            System.out.println();
        }
    }

    public boolean writeToFileUser() {
        try {
            File file = new File("src\\main\\java\\file\\Users.txt");
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(users);
            oos.close();
            fos.close();
            return true;
        } catch (Exception io) {
            System.out.println("Something went wrong");
            return false;
        }
    }
}
