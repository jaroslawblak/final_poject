package com.blak.controllers;


import com.blak.model.Login;
import com.blak.security.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class RestLoginController {

    private UserDetailsService userDetailsService;
    private AuthenticationManager authenticationManager;
    @Autowired
    DaoAuthenticationProvider daoAuthenticationProvider;

    public RestLoginController(UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
        this.userDetailsService = userDetailsService;
        this.authenticationManager = authenticationManager;
    }


    @RequestMapping("/login")
    public ResponseEntity<HttpStatus> login(@RequestBody Login login) {

        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword()));
            SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_GLOBAL);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
