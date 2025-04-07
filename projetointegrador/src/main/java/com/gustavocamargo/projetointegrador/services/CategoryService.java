package com.gustavocamargo.projetointegrador.services;

import com.gustavocamargo.projetointegrador.dtos.CategoryDTO;
import com.gustavocamargo.projetointegrador.entities.Category;
import com.gustavocamargo.projetointegrador.repositories.CategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    @Transactional
    public void registerCategory(CategoryDTO categoryDTO){
        Category entity = new Category(categoryDTO);
        repository.save(entity);
    }

}