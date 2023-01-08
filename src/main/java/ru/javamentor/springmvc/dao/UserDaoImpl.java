package ru.javamentor.springmvc.dao;

import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import ru.javamentor.springmvc.model.User;
import jakarta.persistence.EntityManager;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {


    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getAllUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }


    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void updateUser(int id, User updateUser) {
        User userForUpdate = entityManager.find(User.class, id);
        userForUpdate.setFirstName(updateUser.getFirstName());
        userForUpdate.setLastName(updateUser.getLastName());
        userForUpdate.setEmail(updateUser.getEmail());
        entityManager.merge(userForUpdate);
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(getUser(id));
    }
}