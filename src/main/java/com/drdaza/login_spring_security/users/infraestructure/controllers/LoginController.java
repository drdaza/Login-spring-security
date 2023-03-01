package com.drdaza.login_spring_security.users.infraestructure.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "/api")
public class LoginController {

    @GetMapping(value = "/login")
    public ResponseEntity<Map<String,String>> acces() {
        var auth = SecurityContextHolder.getContext().getAuthentication();
        
        String roleContext = auth.getAuthorities().iterator().next().toString();
        
        if(roleContext != "ROLE_ANONYMOUS"){
            Map<String, String> json = new HashMap<>();
            json.put("message", "Logged");
            json.put("role", roleContext);
            
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(json);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
