package com.blak.serviceImpl;

import com.blak.dao.ResourceDAO;
import com.blak.model.Place;
import com.blak.model.Resource;
import com.blak.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceDAO resourceDAO;


    @Override
    @Transactional
    public Resource getResource(int id) {
        return resourceDAO.getResource(id);
    }

    @Override
    @Transactional
    public void saveResource(Resource resource) {
        resourceDAO.saveResource(resource);
    }

    @Override
    @Transactional
    public boolean deleteResource(int id) {
        return resourceDAO.deleteResource(id);
    }

    @Override
    @Transactional
    public List<Resource> findResourceByPlace(Place place) {
        return resourceDAO.findResourceByPlace(place);
    }

    @Override
    @Transactional
    public List<Resource> getResources() {
        return resourceDAO.getResources();
    }

    @Override
    @Transactional
    public List<Resource> getResourcesForCategory(int id) {
       return resourceDAO.getResourcesForCategory(id);
    }

    @Override
    @Transactional
    public List<Resource> getResourcesForPlace(int id) {
        return resourceDAO.getResourcesForPlace(id);
    }

    @Override
    @Transactional
    public List<Resource> getResourcesForUser(int id) {
        return this.resourceDAO.getResourcesForUser(id);
    }

    @Override
    @Transactional
    public List<Resource> getChildResources(int id) {
        return resourceDAO.getChildResources(id);
    }

}
