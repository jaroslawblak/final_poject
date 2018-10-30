package com.blak.dao;

import com.blak.model.Category;
import com.blak.model.Resource;

import java.util.List;

public interface CategoryDAO {

    public Category getCategory(int id);
    public void saveCategory(Category category);
    public boolean deleteCategory (int id);
    public List<Category> findCategoryByResource(Resource resource);
    public List<Category> getCategories();
}
