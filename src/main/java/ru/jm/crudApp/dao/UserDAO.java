package ru.jm.crudApp.dao;

import ru.jm.crudApp.models.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();
}
