package com.blak.daoImpl;

import com.blak.dao.ResourceDAO;
import com.blak.model.Place;
import com.blak.model.Resource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceDAOImpl implements ResourceDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Resource getResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Resource resource = currentSession.get(Resource.class, id);
        return resource;
    }

    @Override
    public void saveResource(Resource resource) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(resource);
    }

    @Override
    public boolean deleteResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Resource resource = currentSession.get(Resource.class, id);
        currentSession.delete(resource);
        if(currentSession.get(Resource.class, id) == null){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Resource> findResourceByPlace(Place place) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Resource> theQuery = currentSession.createQuery("from Resource where Resource.place.id = :place", Resource.class).setParameter("place",place.getId());
        List<Resource> resources = ((org.hibernate.query.Query) theQuery).getResultList();
        return resources;
    }

    @Override
    public List<Resource> getResources() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Resource> theQuery = currentSession.createQuery("from Resource ", Resource.class);
        List<Resource> resources = ((org.hibernate.query.Query) theQuery).getResultList();
        return resources;
    }
}
