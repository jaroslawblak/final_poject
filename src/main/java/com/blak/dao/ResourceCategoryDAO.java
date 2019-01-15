package com.blak.dao;

import com.blak.model.Category;
import com.blak.model.ResourceCategory;

import java.util.List;

public interface ResourceCategoryDAO {

    public ResourceCategory getResourceCategory(int id);
    public List<ResourceCategory> getResourceCategories();
    public void saveResourceCategory(ResourceCategory resourceCategory);
    public boolean deleteResourceCategory(int id);
    public List<ResourceCategory> findCategoriesByResource(int id);
    public List<ResourceCategory> findResourceByCategory(int id);
    public List<ResourceCategory> getResources();
    public List<Category> getCategoriesOfResource(int id);
    public void updateCategoriesForResource(int id, List<Integer> categoryIds);
    public void updateResourceForCategories(int id, List<Integer> resourceIds);
}
