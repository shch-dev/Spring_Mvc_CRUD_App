package ru.jm.crudApp.service;

import ru.jm.crudApp.models.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public void saveUser(User user);
    public void removeUser(int id);
    public void updateUser(int id, User user);
    public User getUser(int id);


}
