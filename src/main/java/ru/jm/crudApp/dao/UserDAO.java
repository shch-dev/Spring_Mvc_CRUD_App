package ru.jm.crudApp.dao;

import ru.jm.crudApp.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void removeUser(int id);

    public void updateUser(int id, User user);
}
