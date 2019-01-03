package com.blak.controllers;

import com.blak.controllers.HandlersException.UserNotFoundException;
import com.blak.model.Place;
import com.blak.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RestPlaceController {

    @Autowired
    private PlaceService placeService;

    @GetMapping("/places")
    public List<Place> getPlaces() {
        List<Place> places = placeService.getPlaces();
        if (places.isEmpty()) {
            //throw new UserNotFoundException("Users not found ");
        }
        return places;
    }

    @GetMapping("/places/{id}")
    public Place getPlace(@PathVariable int id) {
        Place place = placeService.getPlace(id);
        if (place == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        return place;
    }

    @PostMapping("/places")
    public void savePlace(@RequestBody Place place) {
        place.setId(0);
        placeService.savePlace(place);
    }

    @PutMapping("/places")
    public void updatePlace(@RequestBody Place place) {
        placeService.savePlace(place);
    }

    @DeleteMapping("/places/{id}")
    public void deleteUser(@PathVariable int id) {
        Place place = placeService.getPlace(id);
        if (place == null) {
            throw new UserNotFoundException("User not found - " + id);
        }
        placeService.deletePlace(id);
    }

}
