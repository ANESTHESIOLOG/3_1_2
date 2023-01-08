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
    public void save(User user) {
        entityManager.persist(user);
    }


    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void update(int id, User updateUser) {
        User userForUpdate = entityManager.find(User.class, id);
        userForUpdate.setFirstName(updateUser.getFirstName());
        userForUpdate.setLastName(updateUser.getLastName());
        userForUpdate.setEmail(updateUser.getEmail());
        entityManager.merge(userForUpdate);
    }

    @Override
    public void delete(int id) {
        entityManager.remove(show(id));
    }
}