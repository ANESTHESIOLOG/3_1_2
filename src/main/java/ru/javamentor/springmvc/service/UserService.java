package ru.javamentor.springmvc.service;


import ru.javamentor.springmvc.model.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void updateUser(int id, User updatedUser);

    public void deleteUser(int id);
}
