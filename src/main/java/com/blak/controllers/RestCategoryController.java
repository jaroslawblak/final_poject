package com.blak.controllers;

import com.blak.model.Category;
import com.blak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestCategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> getCategories() {
        List<Category> categories =  categoryService.getCategories();
        if (categories.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return categories;
    }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);
        if (category == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        return category;
    }

    @PostMapping("/categories")
    public void saveCategory(@RequestBody Category category) {
        category.setId(0);
        categoryService.saveCategory(category);
    }

    @PutMapping("/categories")
    public void updateCategory(@RequestBody Category category) {
        categoryService.saveCategory(category);
    }

    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);
        if (category == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        categoryService.deleteCategory(id);
    }
}