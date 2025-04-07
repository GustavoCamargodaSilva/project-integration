package com.gustavocamargo.projetointegrador.services;

import com.gustavocamargo.projetointegrador.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

}
