package com.blak.csvgenerator.UserRes;

import com.blak.model.UserResources;
import com.blak.service.UserResourcesService;
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
public class UserResCsvWriter {

    @Autowired
    private UserResourcesService userResourcesService;

    @Autowired
    private UserResCSVMapper userResCSVMapper;

    private static final String CSV_TITLE = "./KRIM-USER_RES.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<UserResources> userResources = userResourcesService.getAllUsersResources();
            List<CsvUserRes> csvUserRes = userResCSVMapper.toCsvUserRes(userResources);

            final CustomMappingStrategy<CsvUserRes> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvUserRes.class);

            final StatefulBeanToCsv<CsvUserRes> beanToCsv = new StatefulBeanToCsvBuilder<CsvUserRes>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvUserRes);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "Type", "State", "AddTime", "DelTime", "Priority", "DateFrom", "DateTo", "Note", "UserID", "ResourceID", "Parent"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}

