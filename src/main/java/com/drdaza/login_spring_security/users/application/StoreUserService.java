package com.drdaza.login_spring_security.users.application;

import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.users.domain.User;
import com.drdaza.login_spring_security.users.domain.payloads.UserPayLoad;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;



@Service
public class StoreUserService {

    private UserRepository repository;

    public StoreUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User storeUser(UserPayLoad userPayLoad){
        User userToStore = new User(null
                                    , userPayLoad.getUsername()
                                    , userPayLoad.getPassword()
                                    , "ROLE_USER");

        return repository.save(userToStore);
    }
}
