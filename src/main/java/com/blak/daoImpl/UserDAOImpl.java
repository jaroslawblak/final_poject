package com.blak.daoImpl;

import com.blak.dao.UserDAO;
import com.blak.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User getUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        return user;
    }

    @Override
    public void saveUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    public boolean deleteUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user = currentSession.get(User.class, id);
        currentSession.delete(user);
        if (currentSession.get(User.class, id) == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<User> getUsers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<User> theQuery = currentSession.createQuery("from User", User.class);
        List<User> users = ((org.hibernate.query.Query) theQuery).getResultList();
        return users;
    }

    @Override
    public User getUser(String email) {
        Session currentSession = sessionFactory.getCurrentSession();
        try {
            User user = currentSession.createQuery
                    ("from User us where us.email = :email", User.class)
                    .setParameter("email", email).uniqueResult();
            return user;
        } catch (Exception ex) {
            ex.printStackTrace();
            ex.getMessage();
            return null;
        }
    }


}
