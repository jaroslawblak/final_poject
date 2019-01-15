package com.blak.serviceImpl;

import com.blak.csvgenerator.ResRes.ResResCsvWriter;
import com.blak.dao.ResourceOfResourceDAO;
import com.blak.model.ResourceOfResource;
import com.blak.service.ResourceOfResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.util.List;

@Service
public class ResourceOfResourceServiceImpl implements ResourceOfResourceService {

    @Autowired
    private ResourceOfResourceDAO resourceOfResourceDAO;

    @Autowired
    private ResResCsvWriter resResCsvWriter;

    @Override
    @Transactional
    public void getCSVResRes(Path path) throws Exception {
        this.resResCsvWriter.writeCsv(path);
    }

    @Override
    @Transactional
    public List<ResourceOfResource> getResourceOfResources() {
        return this.resourceOfResourceDAO.getResourceOfResources();
    }
}
