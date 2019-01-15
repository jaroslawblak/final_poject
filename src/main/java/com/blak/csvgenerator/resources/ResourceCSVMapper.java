package com.blak.csvgenerator.resources;

import com.blak.model.Resource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResourceCSVMapper implements Serializable {

    public ResourceCSVMapper() {
    }

    public static CsvResource toCsvResource(Resource resource) {

        if (resource == null) {
            return null;
        }

        CsvResource csvResource = new CsvResource();

        csvResource.setId(resource.getId());
        csvResource.setName(resource.getName());
        csvResource.setDescription(resource.getDescription());
        csvResource.setType(resource.getType());
        csvResource.setState(resource.getState());
        csvResource.setAddTime(resource.getAddTime());
        csvResource.setDelTime(resource.getDelTime());
        csvResource.setExternalId(resource.getExternalId());
        if (resource.getPlace() != null) {
            csvResource.setPlaceId(resource.getPlace().getId());
        }
        if (resource.getParentResource() != null) {
            csvResource.setParentResourceId(resource.getParentResource().getId());
        }
        return csvResource;
    }


    public List<CsvResource> toCsvResource(List<Resource> resources) {
        if (resources == null) {
            return null;
        }
        List<CsvResource> csvResources = new ArrayList<>();
        for (Resource resource : resources) {
            CsvResource tempCsvrRes = this.toCsvResource(resource);
            csvResources.add(tempCsvrRes);
        }
        return csvResources;
    }
}
