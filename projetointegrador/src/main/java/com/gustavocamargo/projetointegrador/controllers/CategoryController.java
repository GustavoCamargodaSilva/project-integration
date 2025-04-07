package com.gustavocamargo.projetointegrador.controllers;

import com.gustavocamargo.projetointegrador.dtos.CategoryDTO;
import com.gustavocamargo.projetointegrador.services.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/register")
    public ResponseEntity<Void> registerCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        categoryService.registerCategory(categoryDTO);
        return ResponseEntity.ok().build();
    }
}
