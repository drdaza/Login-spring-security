package com.drdaza.login_spring_security.users.infraestructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.users.application.services.GetOneUserService;
import com.drdaza.login_spring_security.users.domain.models.User;

@RestController
@RequestMapping(path = "/api/users")
public class GetOneUserController {
    
    private GetOneUserService service;

    public GetOneUserController(GetOneUserService service) {
        this.service = service;
    }

    @GetMapping(path = "/{id}")
    public User getOneUser(@PathVariable Long id){
        return service.getOneUser(id);
    }
}
