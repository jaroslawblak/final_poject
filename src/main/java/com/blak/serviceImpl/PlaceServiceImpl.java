package com.blak.serviceImpl;

import com.blak.dao.PlaceDAO;
import com.blak.model.Place;
import com.blak.model.Resource;
import com.blak.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PlaceServiceImpl implements PlaceService {

    @Autowired
    private PlaceDAO placeDAO;

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
    public List<Place> getPlaces() {
        return placeDAO.getPlaces();
    }
}
