package com.gustavocamargo.projetointegrador.services;

import com.gustavocamargo.projetointegrador.dtos.CategoryDTO;
import com.gustavocamargo.projetointegrador.entities.Category;
import com.gustavocamargo.projetointegrador.repositories.CategoryRepository;
import com.gustavocamargo.projetointegrador.services.exception.DataBaseConnectionException;
import com.gustavocamargo.projetointegrador.services.exception.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Slf4j
@Service
public class CategoryService {

    @Autowired
    CategoryRepository repository;

    @Transactional
    public void registerCategory(CategoryDTO categoryDTO){
        log.info("Request to register category: {}", categoryDTO);
        Category entity = new Category(categoryDTO);

        try{
            repository.save(entity);
            log.info("Category registered successfully: {}", entity);
        } catch (Exception e) {
            log.error("Error registering category: {}", e.getMessage());
            throw new DataBaseConnectionException();
        }
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        log.info("Request to find category by id: {}", id);
        try {
            Optional<Category> cat = repository.findById(id);

            if (cat.isEmpty()) {
                log.error("Category not found for id: {}", id);
                throw new ResourceNotFoundException();
            }
            return new CategoryDTO(cat.get());
        } catch (DataAccessException e) {
            log.error("Error finding category by id: {}", e.getMessage());
            throw new DataBaseConnectionException();
        }
    }

    @Transactional
    public CategoryDTO updateCategory(CategoryDTO dto) {
        log.info("Request to update category: {}", dto);
        Category cat = repository.findById(dto.getId()).orElseThrow(DataBaseConnectionException::new);

        Category update = new Category(cat.getId(), cat.getName());

        try{
            repository.save(update);
            log.info("Category updated successfully: {}", update);
        } catch (Exception e) {
            log.error("Error updating category: {}", e.getMessage());
            throw new DataBaseConnectionException();
        }
        return new CategoryDTO(update);
    }

    @Transactional
    public void deleteCategory(Long id) {
        log.info("Request to delete category by id: {}", id);
        try{
            repository.deleteById(id);
            log.info("Category deleted successfully for id: {}", id);
        } catch (Exception e) {
            log.error("Error deleting category: {}", e.getMessage());
            throw new DataBaseConnectionException();
        }
    }
}