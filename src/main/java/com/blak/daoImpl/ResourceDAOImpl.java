package com.blak.daoImpl;

import com.blak.dao.ResourceDAO;
import com.blak.model.Place;
import com.blak.model.Resource;
import com.blak.model.ResourceOfResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class ResourceDAOImpl implements ResourceDAO {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Resource getResource(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Resource.class, id);
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
        currentSession.createSQLQuery("DELETE FROM res2category " +
                "WHERE resourceId =:id")
                .setParameter("id", id)
                .executeUpdate();
        currentSession.delete(resource);
        if(currentSession.get(Resource.class, id) == null){
            return true;
        }
            return false;
    }

    @Override
    public List<Resource> findResourceByPlace(Place place) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Resource> theQuery = currentSession.createQuery("from Resource where Resource.place.id = :place", Resource.class).setParameter("place",place.getId());
        return (theQuery).getResultList();
    }

    @Override
    public List<Resource> getResources() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Resource> theQuery = currentSession.createQuery("from Resource ", Resource.class);
        return (theQuery).getResultList();
    }

    @Override
    public List<Resource> getResourcesForCategory(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return  currentSession.createQuery("select res from Resource res, ResourceCategory rc  where rc.categoryId.id = :id", Resource.class)
                .setParameter("id",id).getResultList();

    }
    @Override
    public List<Resource> getResourcesForPlace(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.createQuery("select res from Resource res join res.place p where p.id = :id", Resource.class)
                .setParameter("id",id).getResultList();
    }

    @Override
    public List<Resource> getResourcesForUser(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Resource> resources = currentSession.createQuery("select res from Resource res, UserResources ur WHERE ur.user.id = :id", Resource.class)
                .setParameter("id",id).getResultList();
        return new ArrayList(new HashSet(resources));
    }

    @Override
    public List<Resource> getChildResources(int id) {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Resource> childResources = new ArrayList<>();
        Query<ResourceOfResource> theQuery = currentSession.createQuery("from ResourceOfResource r where r.parentResourceOfResource.id = :id", ResourceOfResource.class).setParameter("id", id);
        List<ResourceOfResource> resourceOfResource = (theQuery).getResultList();
        for (ResourceOfResource tempResRes : resourceOfResource) {
            childResources.add(tempResRes.getChildResourceOfResource());
        }
        List<Resource> resources = ((org.hibernate.query.Query) theQuery).getResultList();
        return resources;
    }

    @Override
    public void updateResourceForPlace(int id, List<Integer> resourceIds) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.createSQLQuery("UPDATE resource SET placeID = 1 " +
                "WHERE placeID= :id")
                .setParameter("id", id)
                .executeUpdate();
        currentSession.createSQLQuery("UPDATE resource SET placeID = :id " +
                "WHERE ID IN :ids ")
                .setParameter("id", id)
                .setParameter("ids", resourceIds)
                .executeUpdate();

    }
}
