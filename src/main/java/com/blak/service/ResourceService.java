package com.blak.service;

import com.blak.model.Place;
import com.blak.model.Resource;

import java.nio.file.Path;
import java.util.List;

public interface ResourceService {

    public Resource getResource(int id);
    public void saveResource(Resource resource);

    public boolean deleteResource(int id);
    public List<Resource> findResourceByPlace(Place place);
    public List<Resource> getResources();
    public void getCsvResource (Path path) throws Exception;
    public List<Resource> getResourcesForCategory(int id);
    public List<Resource> getResourcesForPlace(int id);
    public List<Resource> getResourcesForUser(int id);
    public List<Resource> getChildResources(int id);
}
