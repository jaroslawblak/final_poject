package com.blak.daoImpl;

import com.blak.dao.UserResourcesDAO;
import com.blak.model.Resource;
import com.blak.model.User;
import com.blak.model.UserResources;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserResourcesDAOImpl implements UserResourcesDAO {

    Logger LOGGER = LoggerFactory.getLogger(UserResourcesDAO.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserResources getUserResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        UserResources userResources = currentSession.get(UserResources.class, id);
        return userResources;
    }

    @Override
    public User getUserFromResId(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        User user  = currentSession.createQuery("SELECT u FROM User u, UserResources ur WHERE u.id = ur.user.id AND ur.resource.id = :id", User.class)
                .setParameter("id", id).getSingleResult();
        return user;
    }

    @Override
    public void saveUserResource(UserResources userResources) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(userResources);
    }

    @Override
    public boolean deleteUserResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        UserResources userResources = currentSession.get(UserResources.class, id);
        currentSession.delete(userResources);
        if(currentSession.get(UserResources.class, id) == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<UserResources> getAllUsersResources() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<UserResources> theQuery = currentSession.createQuery("from UserResources ", UserResources.class);
        List<UserResources> usersResources = ((org.hibernate.query.Query) theQuery).getResultList();
        return usersResources;
    }

    @Override
    public List<UserResources> findUserResourcesByUserId(int userId) {
        Session currentSession = sessionFactory.getCurrentSession();

        List<UserResources> usersResources = currentSession.createQuery("SELECT ur FROM UserResources AS ur WHERE ur.user.id = :id", UserResources.class)
                .setParameter("id", userId).getResultList();
        //List<UserResources> usersResources = ((org.hibernate.query.Query) theQuery).getResultList();
        LOGGER.info(String.valueOf(usersResources));
        return usersResources;

    }

    @Override
    public List<UserResources> findUserResourcesByResource(Resource resource) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<UserResources> theQuery = currentSession.createQuery("from UserResources where UserResources.resource.id = :id", UserResources.class).setParameter("id",resource.getId());
        List<UserResources> usersResources = ((org.hibernate.query.Query) theQuery).getResultList();
        return usersResources;
    }
}
