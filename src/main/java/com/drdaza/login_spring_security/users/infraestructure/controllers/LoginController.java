package com.drdaza.login_spring_security.users.infraestructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.users.application.userDetailsServices.JpaUserDetailsService;
import com.drdaza.login_spring_security.users.domain.payloads.UserPayLoad;

@RestController
@RequestMapping(path = "/login")
public class LoginController {
    private JpaUserDetailsService service;

    public LoginController(JpaUserDetailsService service) {
        this.service = service;
    }

    @PostMapping(path = "")
    public ResponseEntity<UserDetails> login(@RequestBody UserPayLoad payLoad) {

        try {
            UserDetails user = service.loadUserByUsername(payLoad.getUsername());
            return new ResponseEntity<UserDetails>(user,null,201);
        } catch (Exception e) {
            return new ResponseEntity<UserDetails>(null,null, 500);
        }
        
    }
}
