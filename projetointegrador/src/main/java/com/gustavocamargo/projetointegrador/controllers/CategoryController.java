package com.gustavocamargo.projetointegrador.controllers;

import com.gustavocamargo.projetointegrador.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

}
