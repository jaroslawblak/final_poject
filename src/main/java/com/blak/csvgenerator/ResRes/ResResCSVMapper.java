package com.blak.csvgenerator.ResRes;

import com.blak.model.ResourceOfResource;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class ResResCSVMapper implements Serializable {

    public ResResCSVMapper() {
    }

    public static CsvResRes toCsvResRes(ResourceOfResource resourceOfResource){
        if(resourceOfResource == null) {
            return null;
        }
        CsvResRes csvResRes = new CsvResRes();

        csvResRes.setId(resourceOfResource.getId());
        csvResRes.setAddTime(resourceOfResource.getAddTime());
        csvResRes.setDelTime(resourceOfResource.getDelTime());
        csvResRes.setType(resourceOfResource.getType());
        csvResRes.setState(resourceOfResource.getState());
        csvResRes.setParentId(resourceOfResource.getParentResourceOfResource().getId());
        csvResRes.setChildId(resourceOfResource.getChildResourceOfResource().getId());

        return csvResRes;
    }


    public List<CsvResRes> toCsvResRes(List<ResourceOfResource> resourceOfResources){
        if(resourceOfResources == null){
            return null;
        }
        List<CsvResRes> csvResRes = new ArrayList<>();
        for(ResourceOfResource resourceOfResource: resourceOfResources){
            CsvResRes tempCsvResRes = this.toCsvResRes(resourceOfResource);
            csvResRes.add(tempCsvResRes);
        }
        return csvResRes;
    }
}
