package com.drdaza.login_spring_security.users.infraestructure.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api")
public class LoginController {

    @GetMapping(value = "/login")
    public ResponseEntity<Map<String,String>> acces() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(SecurityContextHolder.getContext());
        Map<String, String> json = new HashMap<>();
        json.put("message", "Logged");
        json.put("role", auth.getAuthorities().iterator().next().toString());
        
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
    }
}
