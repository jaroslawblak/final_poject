package com.blak.service;

import com.blak.model.Category;
import com.blak.model.Resource;

import java.util.List;

public interface CategoryService {

    public Category getCategory(int id);
    public void saveCategory(Category category);
    public boolean deleteCategory (int id);
    public List<Category> findCategoryByResource(Resource resource);
    public List<Category> getCategories();
}
