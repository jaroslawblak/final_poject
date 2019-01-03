package com.blak.security;

import com.blak.model.User;
import com.blak.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    Logger LOGGER = LoggerFactory.getLogger(UserDetailsService.class);


    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userService.getUser(email);
        LOGGER.info(user.toString());
        if(user == null){
            throw new UsernameNotFoundException(email);
        }
        return new MyUserPrincipal(user);
    }
}
