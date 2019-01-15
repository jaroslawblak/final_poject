package com.blak.daoImpl;

import com.blak.dao.ResourceOfResourceDAO;
import com.blak.model.ResourceOfResource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResourceOfResourceDAOImpl implements ResourceOfResourceDAO {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<ResourceOfResource> getResourceOfResources() {
        Session currentSession = sessionFactory.getCurrentSession();
        org.hibernate.query.Query<ResourceOfResource> theQuery = currentSession.createQuery("from ResourceOfResource ", ResourceOfResource.class);
        List<ResourceOfResource> resourceOfResources = ((org.hibernate.query.Query) theQuery).getResultList();
        return resourceOfResources;
    }
}
