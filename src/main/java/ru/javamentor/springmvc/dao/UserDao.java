package ru.javamentor.springmvc.dao;


import ru.javamentor.springmvc.model.User;

import java.util.List;

public interface UserDao {

    public List<User> getAllUsers();

    User show(int id);

    void save (User user);

    void update(int id, User updateUser);

    void delete(int id);
}