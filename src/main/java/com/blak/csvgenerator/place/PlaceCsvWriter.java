package com.blak.csvgenerator.place;

import com.blak.model.Place;
import com.blak.service.PlaceService;
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
public class PlaceCsvWriter {

    @Autowired
    private PlaceService placeService;

    @Autowired
    private PlaceCSVMapper placeCSVMapper;

    private static final String CSV_TITLE = "./KRIM-Places.csv";

    public void writeCsv(Path path) throws Exception {
        try (Writer writer = Files.newBufferedWriter(Paths.get(CSV_TITLE))) {
            List<Place> places = placeService.getPlaces();
            List<CsvPlace> csvPlaces = placeCSVMapper.toCsvPlace(places);

            final CustomMappingStrategy<CsvPlace> mappingStrategy = new CustomMappingStrategy<>();
            mappingStrategy.setType(CsvPlace.class);

            final StatefulBeanToCsv<CsvPlace> beanToCsv = new StatefulBeanToCsvBuilder<CsvPlace>(writer)
                    .withMappingStrategy(mappingStrategy)
                    .build();
            beanToCsv.write(csvPlaces);

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