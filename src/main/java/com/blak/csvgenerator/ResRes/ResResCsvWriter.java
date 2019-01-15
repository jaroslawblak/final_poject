package com.blak.csvgenerator.ResRes;

import com.blak.model.ResourceOfResource;
import com.blak.service.ResourceOfResourceService;
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
public class ResResCsvWriter {

    @Autowired
    private ResourceOfResourceService resourceOfResourceService;

    @Autowired
    private ResResCSVMapper resResCSVMapper;

    private static final String CSV_TITLE = "./KRIM-RES_RES.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<ResourceOfResource> resourceOfResources = resourceOfResourceService.getResourceOfResources();
            List<CsvResRes> csvResRes = resResCSVMapper.toCsvResRes(resourceOfResources);

            final CustomMappingStrategy<CsvResRes> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvResRes.class);

            final StatefulBeanToCsv<CsvResRes> beanToCsv = new StatefulBeanToCsvBuilder<CsvResRes>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvResRes);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "AddTime", "DelTime", "ParentID", "ChildId", "Type", "State"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}

