package com.gustavocamargo.projetointegrador.services;

import com.gustavocamargo.projetointegrador.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

}
