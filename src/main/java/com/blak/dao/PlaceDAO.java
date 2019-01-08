package com.blak.dao;

import com.blak.model.Place;
import com.blak.model.Resource;

import java.util.List;

public interface PlaceDAO {


    public Place getPlace(int id);
    public Place getPlaceByName(String name);
    public void savePlace(Place place);
    public boolean deletePlace (int id);
    public List<Place> findPlaceByResource(Resource resource);
    public List<Place> getPlaces();
}
