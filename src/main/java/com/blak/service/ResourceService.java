package com.blak.service;

import com.blak.model.Place;
import com.blak.model.Resource;

import java.util.List;

public interface ResourceService {

    public Resource getResource(int id);
    public void saveResource(Resource resource);
    public boolean deleteResource(int id);
    public List<Resource> findResourceByPlace(Place place);
    public List<Resource> getResources();
}
