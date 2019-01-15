package com.blak.controllers;

import com.blak.service.ResourceCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@CrossOrigin
public class RestResourceCategoryController {

    @Autowired
    private ResourceCategoryService resourceCategoryService;


    @GetMapping("/rescat/csv")
    public void getCSVResCat() throws Exception {
        Path p1 = Paths.get("/tmp/foo");
        resourceCategoryService.getCSVResCat(p1);
    }
}
