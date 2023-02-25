package com.drdaza.login_spring_security.users.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drdaza.login_spring_security.users.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
