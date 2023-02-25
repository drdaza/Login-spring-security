package com.drdaza.login_spring_security.users.application.services;

import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.users.domain.models.User;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;

@Service
public class GetOneUserService {
    
    private UserRepository repository;

    public GetOneUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getOneUser(Long id){
        return repository.findById(id).orElseThrow(null);
    }
}
