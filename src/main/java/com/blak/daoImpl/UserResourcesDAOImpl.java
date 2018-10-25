package com.blak.daoImpl;

import com.blak.dao.UserResourcesDAO;
import com.blak.model.Resource;
import com.blak.model.User;
import com.blak.model.UserResources;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserResourcesDAOImpl implements UserResourcesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public UserResources getUserResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        UserResources userResources = currentSession.get(UserResources.class, id);
        return userResources;
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
    public List<UserResources> findUserResourcesByUser(User user) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<UserResources> theQuery = currentSession.createQuery("from UserResources where UserResources.user.id = :id", UserResources.class).setParameter("id",user.getId());
        List<UserResources> usersResources = ((org.hibernate.query.Query) theQuery).getResultList();
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
