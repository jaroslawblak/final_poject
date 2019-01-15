package com.blak.csvgenerator.UserRes;

import com.blak.model.UserResources;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserResCSVMapper implements Serializable {

    public UserResCSVMapper() {
    }

    public static CsvUserRes toCsvUserRes(UserResources userResources){
        if(userResources == null) {
            return null;
        }
        CsvUserRes csvUserRes = new CsvUserRes();

        csvUserRes.setId(userResources.getId());
        csvUserRes.setType(userResources.getType());
        csvUserRes.setState(userResources.getState());
        csvUserRes.setAddTime(userResources.getAddTime());
        csvUserRes.setDelTime(userResources.getDelTime());
        csvUserRes.setPriority(userResources.getPriority());
        csvUserRes.setDateFrom(userResources.getDateFrom());
        csvUserRes.setDateTo(userResources.getDateTo());
        csvUserRes.setNote(userResources.getNote());

        if (userResources.getUser() != null) {
            csvUserRes.setUserId(userResources.getUser().getId());
        }
        if (userResources.getResource() != null) {
            csvUserRes.setResourceId(userResources.getResource().getId());
        }
        if (userResources.getParentUserResources() != null) {
            csvUserRes.setParentId(userResources.getParentUserResources().getId());
        }

        return csvUserRes;
    }


    public List<CsvUserRes> toCsvUserRes(List<UserResources> userResources){
        if(userResources == null){
            return null;
        }
        List<CsvUserRes> csvUserRes = new ArrayList<>();
        for(UserResources tempUserResources: userResources){
            CsvUserRes tempCsvUserRes = this.toCsvUserRes(tempUserResources);
            csvUserRes.add(tempCsvUserRes);
        }
        return csvUserRes;
    }
}
