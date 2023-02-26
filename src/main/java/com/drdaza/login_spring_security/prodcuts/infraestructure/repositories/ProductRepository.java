package com.drdaza.login_spring_security.prodcuts.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drdaza.login_spring_security.prodcuts.domain.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
