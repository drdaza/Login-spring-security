package com.drdaza.login_spring_security.prodcuts.infraestructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drdaza.login_spring_security.prodcuts.application.services.ListAllService;
import com.drdaza.login_spring_security.prodcuts.domain.models.Product;

@RestController
@RequestMapping(path = "/api/products")
public class ListAllController {
    
    private ListAllService service;

    public ListAllController(ListAllService service) {
        this.service = service;
    }

    public List<Product> listAll() {
        return service.listAll();
    }
}
