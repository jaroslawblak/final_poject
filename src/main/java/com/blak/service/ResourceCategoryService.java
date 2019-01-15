package com.blak.service;

import com.blak.model.ResourceCategory;

import java.nio.file.Path;
import java.util.List;

public interface ResourceCategoryService {
    public void getCSVResCat (Path path) throws Exception;
    public List<ResourceCategory> getResourceCategories();


}
