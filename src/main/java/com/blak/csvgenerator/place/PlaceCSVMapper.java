package com.blak.csvgenerator.place;

import com.blak.model.Place;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class PlaceCSVMapper implements Serializable {

    public PlaceCSVMapper() {
    }

    public static CsvPlace toCsvPlace(Place place){
        if(place == null) {
            return null;
        }
        CsvPlace csvPlace = new CsvPlace();

        csvPlace.setId(place.getId());
        csvPlace.setName(place.getName());
        csvPlace.setNote(place.getNote());

        if(place.getParentPlace()!= null){
            csvPlace.setParentPlaceId(place.getParentPlace().getId());
        }
        return csvPlace;
    }


    public List<CsvPlace> toCsvPlace(List<Place> places){
        if(places == null){
            return null;
        }
        List<CsvPlace> csvPlaces = new ArrayList<>();
        for(Place place: places){
            CsvPlace tempCsvPlace = this.toCsvPlace(place);
            csvPlaces.add(tempCsvPlace);
        }
        return csvPlaces;
    }
}
