package com.blak.csvgenerator.document;

import com.blak.model.Document;
import com.blak.service.DocumentService;
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
public class DocumentCsvWriter {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private DocumentCSVMapper documentCSVMapper;

    private static final String CSV_TITLE = "./KRIM-Documents.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<Document> documents = documentService.getDocuments();
            List<CsvDocument> csvDocuments = documentCSVMapper.toCsvDocument(documents);

            final CustomMappingStrategy<CsvDocument> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvDocument.class);

            final StatefulBeanToCsv<CsvDocument> beanToCsv = new StatefulBeanToCsvBuilder<CsvDocument>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvDocuments);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class CustomMappingStrategy<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[]{"ID", "File Name", "Title", "Type", "AddTime", "DelTime", "Resource"};

    @Override
    public String[] generateHeader() {
        return HEADER;
    }
}

