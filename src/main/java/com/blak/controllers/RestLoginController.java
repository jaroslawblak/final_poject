package com.blak.controllers;


import com.blak.model.User;
import com.blak.security.MyUserPrincipal;
import com.blak.security.UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Base64;

@RestController
@CrossOrigin
public class RestLoginController {

    Logger LOGGER = LoggerFactory.getLogger(RestLoginController.class);

    @Autowired
    private UserDetailsService userDetailsService;

    @RequestMapping("/login")
    public User login(@RequestBody User user) {
        try {
            MyUserPrincipal myUserPrincipal = (MyUserPrincipal) userDetailsService.loadUserByUsername(user.getEmail());
            if(myUserPrincipal.getPassword().equals(user.getPassword())) {
                return myUserPrincipal.getUser();
            }
        }catch (Exception exc){
            return null;
        }
        return null;
    }

    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization").substring("Basic".length()).trim();
        return () -> new String(Base64.getDecoder().decode(authToken)).split(":")[0];
    }
}
