package com.blak.csvgenerator.user;

import com.blak.model.User;
import com.blak.service.UserService;
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
public class UserCsvWriter {

    @Autowired
    private UserService userService;

    @Autowired
    private UserCSVMapper userCSVMapper;

    private static final String CSV_TITLE = "./KRIM-Users.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<User> users = userService.getUsers();
            List<CsvUser> csvUsers = userCSVMapper.toCsvUser(users);

            final CustomMappingStrategy<CsvUser> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvUser.class);

            final StatefulBeanToCsv<CsvUser> beanToCsv = new StatefulBeanToCsvBuilder<CsvUser>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvUsers);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {"ID", "First Name", "Last Name", "Email", "Password", "Type", "State", "AddTime", "DelTime", "Note", "AuthKey", "Role", "Parent"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}