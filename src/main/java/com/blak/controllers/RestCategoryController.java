package com.blak.controllers;

import com.blak.model.Category;
import com.blak.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
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

    @GetMapping("/categories/csv")
    public void getCsvCategories() throws Exception{
        Path p1 = Paths.get("/tmp/foo");
        categoryService.getCsvCategory(p1);
    }



    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable int id) {
        Category category = categoryService.getCategory(id);
        if (category == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        return category;
    }

    @GetMapping("/categories/name/{name}")
    public Category getCategoryByName(@PathVariable String name) {
        Category category = categoryService.getCategoryByName(name);
        if (category == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        return category;
    }

    @GetMapping("/categories/res/{id}")
    public List<Category> getCategoriesForResource(@PathVariable int id) {
        List<Category> categories = categoryService.getCategoriesOfResource(id);
        if (categories == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        return categories;
    }

    @PostMapping("/categories")
    public void saveCategory(@RequestBody Category category) {
        category.setId(0);
        categoryService.saveCategory(category);
    }

    @PostMapping("/categories/res/{id}")
    public void saveCategoryForResource(@PathVariable int id, @RequestBody List<Integer> categoryIds) {
        categoryService.updateCategoriesForResource(id, categoryIds);
    }

    @PostMapping("/categories/res/cat/{id}")
    public void saveResourceForCategory(@PathVariable int id, @RequestBody List<Integer> resourceIds) {
        categoryService.updateResourceForCategories(id, resourceIds);
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
