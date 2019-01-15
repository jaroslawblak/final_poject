package com.blak.csvgenerator.Category;

import com.blak.model.Category;
import com.blak.service.CategoryService;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class CategoryCsvWriter {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryCSVMapper categoryCSVMapper;

    private static final String CSV_TITLE = "./KRIM-Category.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<Category> categories = categoryService.getCategories();
            List<CsvCategory> csvCategories = categoryCSVMapper.toCsvCategory(categories);

            final CustomMappingStrategy<CsvCategory> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvCategory.class);

            final StatefulBeanToCsv<CsvCategory> beanToCsv = new StatefulBeanToCsvBuilder<CsvCategory>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvCategories);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "Name", "Note", "Parent"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}

