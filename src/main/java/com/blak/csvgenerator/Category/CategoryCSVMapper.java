package com.blak.csvgenerator.Category;

import com.blak.model.Category;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryCSVMapper implements Serializable {
    public CategoryCSVMapper() {
    }

    public static CsvCategory toCsvCategory(Category category){
        if(category == null) {
            return null;
        }
        CsvCategory csvCategory = new CsvCategory();

        csvCategory.setId(category.getId());
        csvCategory.setName(category.getName());
        csvCategory.setNote(category.getNote());

        if(category.getParentCategory()!= null){
            csvCategory.setParentCategoryId(category.getParentCategory().getId());
        }
        return csvCategory;
    }


    public List<CsvCategory> toCsvCategory(List<Category> categories){
        if(categories == null){
            return null;
        }
        List<CsvCategory> csvCategories = new ArrayList<>();
        for(Category category: categories){
            CsvCategory tempCsvCategory = this.toCsvCategory(category);
            csvCategories.add(tempCsvCategory);
        }
        return csvCategories;
    }
}
