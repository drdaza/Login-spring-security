package com.drdaza.login_spring_security.users.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.users.domain.models.User;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;

@Service
public class ListAllUsersService {
    
    private UserRepository repository;

    public ListAllUsersService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> ListAllUsers(){
        return repository.findAll();
    }
}
