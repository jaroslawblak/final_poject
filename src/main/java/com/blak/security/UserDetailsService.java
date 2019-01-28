package com.blak.security;

import com.blak.dao.UserDAO;
import com.blak.model.User;
import org.hibernate.validator.internal.constraintvalidators.bv.EmailValidator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private UserDAO userDAO;

    public UserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        if(new EmailValidator().isValid(email, null)){
            User user = userDAO.getUser(email);
            return new MyUserPrincipal(user);
        } else {
            throw new UsernameNotFoundException("Bad email or not user in database");
        }
    }
}
