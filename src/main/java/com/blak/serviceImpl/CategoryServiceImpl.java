package com.blak.serviceImpl;

import com.blak.dao.CategoryDAO;
import com.blak.model.Category;
import com.blak.model.Resource;
import com.blak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    @Transactional
    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Override
    @Transactional
    public boolean deleteCategory(int id) {
        return categoryDAO.deleteCategory(id);
    }

    @Override
    @Transactional
    public List<Category> findCategoryByResource(Resource resource) {
        return categoryDAO.findCategoryByResource(resource);
    }

    @Override
    @Transactional
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }
}
