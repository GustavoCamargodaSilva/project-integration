package com.gustavocamargo.projetointegrador.controllers;

import com.gustavocamargo.projetointegrador.dtos.CategoryDTO;
import com.gustavocamargo.projetointegrador.services.CategoryService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping(value = "/register")
    public ResponseEntity<Void> registerCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        log.info("POST /register - Request: {}", categoryDTO);
        categoryService.registerCategory(categoryDTO);
        log.info("POST /register - Response: 200 OK");
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<CategoryDTO> findById(@PathVariable Long id){
        log.info("GET /findbyid/{} - Request", id);
        CategoryDTO dto = categoryService.findById(id);
        log.info("GET /findbyid/{} - Response: {}", id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @PutMapping("/update")
    public ResponseEntity<Void> updateCategory(@RequestBody CategoryDTO categoryDTO) {
        log.info("PUT /update - Request: {}", categoryDTO);
        CategoryDTO dto = categoryService.updateCategory(categoryDTO);
        log.info("PUT /update - Response: 200 OK");
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CategoryDTO> deleteCategory(@PathVariable Long id){
        log.info("DELETE /delete/{} - Request", id);
        categoryService.deleteCategory(id);
        log.info("DELETE /delete/{} - Response: 204 No Content", id);
        return ResponseEntity.noContent().build();
    }

}
