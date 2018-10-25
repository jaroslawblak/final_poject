package com.blak.daoImpl;

import com.blak.dao.ResourceDAO;
import com.blak.model.Resource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ResourceDAOImpl implements ResourceDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Resource getResource(String name) {
        return null;
    }

    @Override
    public void saveResource() {

    }

    @Override
    public boolean deleteResource() {
        return false;
    }

    @Override
    public void searchResource() {

    }

    @Override
    public List<Resource> getResources() {
        return null;
    }
}
