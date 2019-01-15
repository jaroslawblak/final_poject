package com.blak.csvgenerator.ResCat;

import com.blak.model.ResourceCategory;
import com.blak.service.ResourceCategoryService;
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
public class ResCatCsvWriter {

    @Autowired
    private ResourceCategoryService resourceCategoryService;

    @Autowired
    private ResCatCSVMapper resCatCSVMapper;

    private static final String CSV_TITLE = "./KRIM-RES_CAT.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<ResourceCategory> resourceCategories = resourceCategoryService.getResourceCategories();
            List<CsvResourceCategory> csvResourceCategories = resCatCSVMapper.toCsvResCat(resourceCategories);

            final CustomMappingStrategy<CsvResourceCategory> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvResourceCategory.class);

            final StatefulBeanToCsv<CsvResourceCategory> beanToCsv = new StatefulBeanToCsvBuilder<CsvResourceCategory>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvResourceCategories);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "ResourcceID", "CategoryID"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}

