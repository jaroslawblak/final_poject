package com.blak.dao;

import com.blak.model.Resource;

import java.util.List;

public interface ResourceDAO {

    public Resource getResource(String name);
    public void saveResource();
    public boolean deleteResource();
    public void searchResource();
    public List<Resource> getResources();
}
