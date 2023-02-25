package com.drdaza.login_spring_security.users.infraestructure.controllers;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.users.application.ListAllUsersService;
import com.drdaza.login_spring_security.users.domain.User;


@RestController
@RequestMapping(path = "/api/users")
public class ListAllUsersController {
    private ListAllUsersService service;

    public ListAllUsersController(ListAllUsersService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<User> listAllUsers() {
        return service.ListAllUsers();
    }
}
