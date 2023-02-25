package com.drdaza.login_spring_security.users.infraestructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.users.application.services.DeleteUserService;
import com.drdaza.login_spring_security.users.domain.models.User;

@RestController
@RequestMapping(path = "/api/users")
public class DeleteUserController {
    
    private DeleteUserService service;

    public DeleteUserController(DeleteUserService service) {
        this.service = service;
    }

    @DeleteMapping(path = "/{id}")
    public List<User> deleteUser(@PathVariable Long id){
        return service.deleteUser(id);
    }
}
