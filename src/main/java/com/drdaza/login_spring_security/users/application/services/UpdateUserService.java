package com.drdaza.login_spring_security.users.application.services;



import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.users.domain.models.User;
import com.drdaza.login_spring_security.users.domain.payloads.UserPayLoad;
import com.drdaza.login_spring_security.users.infraestructure.repositories.UserRepository;

@Service
public class UpdateUserService {
    
    private UserRepository repository;

    public UpdateUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User updateUser(Long id, UserPayLoad userToModify){

        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        String newPassword = encoder.encode(userToModify.getPassword());
        
        return repository.findById(id).map(userModify -> {
                userModify.setPassword(newPassword);
                return repository.save(userModify);
               }).orElseThrow(null);
    }
}
