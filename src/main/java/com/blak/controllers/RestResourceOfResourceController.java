package com.blak.controllers;

import com.blak.service.ResourceOfResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class RestResourceOfResourceController {


    @Autowired
    private ResourceOfResourceService resourceOfResourceService;


    @GetMapping("/resres/csv")
    public void getCSVResCat() throws Exception {
        Path p1 = Paths.get("/tmp/foo");
        resourceOfResourceService.getCSVResRes(p1);
    }
}

