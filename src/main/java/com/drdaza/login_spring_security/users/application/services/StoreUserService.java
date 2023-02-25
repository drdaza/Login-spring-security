package com.drdaza.login_spring_security.users.application.services;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.users.domain.models.User;
import com.drdaza.login_spring_security.users.domain.payloads.UserPayLoad;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;



@Service
public class StoreUserService {

    private UserRepository repository;


    public StoreUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User storeUser(UserPayLoad userPayLoad){

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String password = encoder.encode(userPayLoad.getPassword());
        
        User userToStore = new User(null
                                    , userPayLoad.getUsername()
                                    , password
                                    , "ROLE_USER");

        return repository.save(userToStore);
    }
}
