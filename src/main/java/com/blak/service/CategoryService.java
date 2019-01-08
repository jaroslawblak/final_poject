package com.blak.service;

import com.blak.model.Category;

import java.util.List;

public interface CategoryService {

    public Category getCategory(int id);
    public Category getCategoryByName(String name);
    public void saveCategory(Category category);
    public boolean deleteCategory (int id);
    public List<Category> findCategoryByResource(int id);
    public List<Category> getCategories();
    public List<Category> getCategoriesOfResource(int id);
    public void updateCategoriesForResource(int id, List<Integer> categoryIds);
    public void updateResourceForCategories(int id, List<Integer> resourceIds);
}
