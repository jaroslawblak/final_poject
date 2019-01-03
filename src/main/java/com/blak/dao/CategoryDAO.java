package com.blak.dao;

import com.blak.model.Category;

import java.util.List;

public interface CategoryDAO {

    public Category getCategory(int id);
    public void saveCategory(Category category);
    public boolean deleteCategory (int id);
    public List<Category> findCategoryByResource(int id);
    public List<Category> getCategories();
}
