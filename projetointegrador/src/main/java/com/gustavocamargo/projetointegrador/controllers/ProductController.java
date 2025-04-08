package com.gustavocamargo.projetointegrador.controllers;

import com.gustavocamargo.projetointegrador.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    ProductService service;
}
