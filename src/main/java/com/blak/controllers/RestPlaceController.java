package com.blak.controllers;

import com.blak.controllers.HandlersException.UserNotFoundException;
import com.blak.model.Place;
import com.blak.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
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
    @PostMapping("/places/res/place/{id}")
    public void saveResourceForPlace(@PathVariable int id, @RequestBody List<Integer> resourceIds) {
        placeService.updateResourceForPlace(id, resourceIds);
    }

    @GetMapping("/places/name/{name}")
    public Place getPlaceByName(@PathVariable String name) {
        Place place = placeService.getPlaceByName(name);
        if (place == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        return place;
    }
    @PostMapping("/places")
    public void savePlace(@RequestBody Place place) {
        place.setId(0);
        placeService.savePlace(place);
    }

    @GetMapping("/places/csv")
    public void getCSVPlaces() throws Exception {
        Path p1 = Paths.get("/tmp/foo");
        placeService.getCsvPlace(p1);
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
