package com.blak.csvgenerator.user;

import com.blak.model.User;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserCSVMapper implements Serializable {

    public UserCSVMapper() {
    }

    public static CsvUser toCsvUser(User user){
        if(user == null) {
            return null;
        }
        CsvUser csvUser = new CsvUser();

        csvUser.setId(user.getId());
        csvUser.setFirstName(user.getFirstName());
        csvUser.setLastName(user.getLastName());
        csvUser.setEmail(user.getEmail());
        csvUser.setPassword(user.getPassword());
        csvUser.setType(user.getType());
        csvUser.setState(user.getState());
        csvUser.setAddTime(user.getAddTime());
        csvUser.setDelTime(user.getDelTime());
        csvUser.setNote(user.getNote());
        csvUser.setAuthKey(user.getAuthKey());
        csvUser.setRole(user.getRole());
        if (user.getParentUser() != null) {
            csvUser.setParentUserId(user.getParentUser().getId());
        }

        return csvUser;
    }


    public List<CsvUser> toCsvUser(List<User> users){
        if(users == null){
            return null;
        }
        List<CsvUser> csvUsers = new ArrayList<>();
        for(User user: users){
            CsvUser tempCsvUser = this.toCsvUser(user);
            csvUsers.add(tempCsvUser);
        }
        return csvUsers;
    }
}
