package com.drdaza.login_spring_security.prodcuts.application.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.drdaza.login_spring_security.prodcuts.domain.models.Product;
import com.drdaza.login_spring_security.prodcuts.infraestructure.repositories.ProductRepository;

@Service
public class ListAllService {
    
    private ProductRepository repository;

    public ListAllService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> listAll() {
        return repository.findAll();
    }
}
