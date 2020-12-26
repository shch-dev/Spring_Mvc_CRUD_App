package ru.jm.crudApp.dao;

import org.springframework.stereotype.Repository;
import ru.jm.crudApp.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        String HQL = "FROM User";
        Query query = entityManager.createQuery(HQL);
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User getUser(int id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    @Override
    public void removeUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public void updateUser(int id, User userUpdate) {
        User user = entityManager.find(User.class, id);
        user.setName(userUpdate.getName());
        user.setSurname(userUpdate.getSurname());
        user.setEmail(userUpdate.getEmail());
        entityManager.flush();
    }
}
