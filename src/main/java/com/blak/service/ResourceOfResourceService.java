package com.blak.service;

import com.blak.model.ResourceOfResource;

import java.nio.file.Path;
import java.util.List;

public interface ResourceOfResourceService {
    public void getCSVResRes (Path path) throws Exception;
    public List<ResourceOfResource> getResourceOfResources();

}
