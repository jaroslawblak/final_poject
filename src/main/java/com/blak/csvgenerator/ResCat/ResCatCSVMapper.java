package com.blak.csvgenerator.ResCat;

import com.blak.model.ResourceCategory;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResCatCSVMapper implements Serializable {

    public ResCatCSVMapper() {
    }

    public static CsvResourceCategory toCsvResCat(ResourceCategory resourceCategory){
        if(resourceCategory == null) {
            return null;
        }
        CsvResourceCategory csvResourceCategory = new CsvResourceCategory();

        csvResourceCategory.setId(resourceCategory.getId());
        csvResourceCategory.setResourceId(resourceCategory.getResourceId().getId());
        csvResourceCategory.setCategoryId(resourceCategory.getCategoryId().getId());


        return csvResourceCategory;
    }


    public List<CsvResourceCategory> toCsvResCat(List<ResourceCategory> resourceCategories){
        if(resourceCategories == null){
            return null;
        }
        List<CsvResourceCategory> csvResourceCategories = new ArrayList<>();
        for(ResourceCategory resourceCategory: resourceCategories){
            CsvResourceCategory tempCsvResCat = this.toCsvResCat(resourceCategory);
            csvResourceCategories.add(tempCsvResCat);
        }
        return csvResourceCategories;
    }
}
