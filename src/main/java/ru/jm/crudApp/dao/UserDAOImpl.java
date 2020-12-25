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

}
