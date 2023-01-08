package ru.javamentor.springmvc.service;


import ru.javamentor.springmvc.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User show(int id);

    public void save(User user);

    public void update(int id, User updatedUser);

    public void delete(int id);
}
