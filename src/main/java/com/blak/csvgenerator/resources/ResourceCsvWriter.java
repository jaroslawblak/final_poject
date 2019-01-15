package com.blak.csvgenerator.resources;

import com.blak.model.Resource;
import com.blak.service.ResourceService;
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
public class ResourceCsvWriter {

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ResourceCSVMapper resourceCSVMapper;

    private static final String CSV_TITLE = "./KRIM-Resources.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<Resource> resources = resourceService.getResources();
            List<CsvResource> csvResources = resourceCSVMapper.toCsvResource(resources);

            final CustomMappingStrategy<CsvResource> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvResource.class);

            final StatefulBeanToCsv<CsvResource> beanToCsv = new StatefulBeanToCsvBuilder<CsvResource>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvResources);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "Name", "Description", "Type", "State",
            "AddTime", "DelTime", "ExternalID", "Place",
            "Parent"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}