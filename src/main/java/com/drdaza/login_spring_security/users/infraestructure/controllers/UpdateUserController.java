package com.drdaza.login_spring_security.users.infraestructure.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.users.application.services.UpdateUserService;
import com.drdaza.login_spring_security.users.domain.models.User;
import com.drdaza.login_spring_security.users.domain.payloads.UserPayLoad;

@RestController
@RequestMapping(path = "/api/users")
public class UpdateUserController {
    
    private UpdateUserService service;

    public UpdateUserController(UpdateUserService service) {
        this.service = service;
    }

    @PutMapping(path = "/{id}")
    public User updateUserPassword(@PathVariable Long id, @RequestBody UserPayLoad userPayLoad) {
        return service.updateUser(id, userPayLoad);
    }
}
