package com.drdaza.login_spring_security.users.infraestructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.users.application.StoreUserService;
import com.drdaza.login_spring_security.users.domain.User;
import com.drdaza.login_spring_security.users.domain.payloads.UserPayLoad;

@RestController
@RequestMapping(path = "/api/users")
public class StoreUserController {
    
    private StoreUserService service;

    public StoreUserController(StoreUserService service) {
        this.service = service;
    }

    @PostMapping(path = "")
    public User storUser(@RequestBody UserPayLoad userPayLoad) {
        return service.storeUser(userPayLoad);
    }
}
