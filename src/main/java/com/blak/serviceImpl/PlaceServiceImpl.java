package com.blak.serviceImpl;

import com.blak.csvgenerator.place.PlaceCsvWriter;
import com.blak.dao.PlaceDAO;
import com.blak.dao.ResourceDAO;
import com.blak.model.Place;
import com.blak.model.Resource;
import com.blak.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDAO placeDAO;

    @Autowired
    private PlaceCsvWriter placeCsvWriter;

    @Autowired
    private ResourceDAO resourceDAO;

    @Override
    @Transactional
    public Place getPlace(int id) {
        return placeDAO.getPlace(id);
    }

    @Override
    @Transactional
    public void savePlace(Place place) {
        placeDAO.savePlace(place);
    }

    @Override
    @Transactional
    public boolean deletePlace(int id) {
        return placeDAO.deletePlace(id);
    }

    @Override
    @Transactional
    public List<Place> findPlaceByResource(Resource resource) {
        return placeDAO.findPlaceByResource(resource);
    }

    @Override
    @Transactional
    public Place getPlaceByName(String name) {
        return placeDAO.getPlaceByName(name);
    }

    @Override
    @Transactional
    public List<Place> getPlaces() {
        return placeDAO.getPlaces();
    }

    @Override
    @Transactional
    public void getCsvPlace(Path path) throws Exception {
        this.placeCsvWriter.writeCsv(path);
    }

    @Override
    @Transactional
    public void updateResourceForPlace(int id, List<Integer> resourceIds) {
        resourceDAO.updateResourceForPlace(id, resourceIds);
    }
}
