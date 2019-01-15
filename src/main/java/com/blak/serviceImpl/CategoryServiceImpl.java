package com.blak.serviceImpl;

import com.blak.csvgenerator.Category.CategoryCsvWriter;
import com.blak.dao.CategoryDAO;
import com.blak.dao.ResourceCategoryDAO;
import com.blak.model.Category;
import com.blak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private ResourceCategoryDAO resourceCategoryDAO;

    @Autowired
    private CategoryCsvWriter categoryCsvWriter;


    @Override
    @Transactional
    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Override
    @Transactional
    public Category getCategoryByName(String name) {
        return categoryDAO.getCategoryByName(name);
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
    public List<Category> findCategoryByResource(int id) {

        return categoryDAO.findCategoryByResource(id);
    }

    @Override
    @Transactional
    public List<Category> getCategories() {
        return categoryDAO.getCategories();
    }

    @Override
    @Transactional
    public List<Category> getCategoriesOfResource(int id) {
        return resourceCategoryDAO.getCategoriesOfResource(id);
    }

    @Override
    @Transactional
    public void getCsvCategory(Path path) throws Exception {
            this.categoryCsvWriter.writeCsv(path);
    }

    @Override
    @Transactional
    public void updateCategoriesForResource(int id, List<Integer> categoryIds) {
        resourceCategoryDAO.updateCategoriesForResource(id, categoryIds);
    }

    @Override
    @Transactional
    public void updateResourceForCategories(int id, List<Integer> resourceIds) {
        resourceCategoryDAO.updateResourceForCategories(id, resourceIds);
    }


}
