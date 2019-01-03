package com.blak.controllers;

import com.blak.model.Resource;
import com.blak.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class RestResourceController {

    @Autowired
    private ResourceService resourceService;

    @GetMapping("/resources")
    public List<Resource> getResources() {
        List<Resource> resources = resourceService.getResources();
        return resources;
    }

    @GetMapping("/resources/{id}/child")
    public List<Resource> getChildResources(@PathVariable int id) {
        List<Resource> resources = resourceService.getChildResources(id);
        return resources;
    }

    @GetMapping("/resources/{id}")
    public Resource getResource(@PathVariable int id) {
        Resource resource = resourceService.getResource(id);
        return resource;
    }

    @PostMapping("/resources")
    public void saveResource(@RequestBody Resource resource) {
        resource.setId(0);
        resourceService.saveResource(resource);
    }

    @PutMapping("/resources")
    public void updateResource(@RequestBody Resource resource) {
        System.out.println("BUG ");
        System.out.println("res: " + resource);
        resourceService.saveResource(resource);
    }

    @DeleteMapping("/resources/{id}")
    public void deleteResource(@PathVariable int id) {
        Resource resource = resourceService.getResource(id);
        if (resource == null) {
            //throw new UserNotFoundException("User not found - " + id);
        }
        resourceService.deleteResource(id);
    }
}
