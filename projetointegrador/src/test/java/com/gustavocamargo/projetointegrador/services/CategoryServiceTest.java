package com.gustavocamargo.projetointegrador.services;

import com.gustavocamargo.projetointegrador.dtos.CategoryDTO;
import com.gustavocamargo.projetointegrador.entities.Category;
import com.gustavocamargo.projetointegrador.repositories.CategoryRepository;
import com.gustavocamargo.projetointegrador.services.exception.DataBaseConnectionException;
import com.gustavocamargo.projetointegrador.services.exception.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.DataAccessException;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registerCategorySuccessfully() {
        CategoryDTO categoryDTO = new CategoryDTO();
        Category category = new Category(categoryDTO);

        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        assertDoesNotThrow(() -> categoryService.registerCategory(categoryDTO));
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    void registerCategoryThrowsException() {
        CategoryDTO categoryDTO = new CategoryDTO();
        doThrow(new DataBaseConnectionException()).when(categoryRepository).save(any(Category.class));

        assertThrows(DataBaseConnectionException.class, () -> categoryService.registerCategory(categoryDTO));
    }

    @Test
    void findByIdSuccessfully() {
        Long id = 1L;
        Category category = new Category();
        when(categoryRepository.findById(id)).thenReturn(Optional.of(category));

        CategoryDTO result = categoryService.findById(id);

        assertNotNull(result);
        verify(categoryRepository, times(1)).findById(id);
    }

    @Test
    void findByIdThrowsResourceNotFoundException() {
        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> categoryService.findById(id));
    }

    @Test
    void findByIdThrowsDataBaseConnectionException() {
        Long id = 1L;
        when(categoryRepository.findById(id)).thenThrow(new DataAccessException("...") {});

        assertThrows(DataBaseConnectionException.class, () -> categoryService.findById(id));
    }

    @Test
    void updateCategorySuccessfully() {
        CategoryDTO categoryDTO = new CategoryDTO();
        Category category = new Category();
        when(categoryRepository.findById(categoryDTO.getId())).thenReturn(Optional.of(category));
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        assertDoesNotThrow(() -> categoryService.updateCategory(categoryDTO));
        verify(categoryRepository, times(1)).save(any(Category.class));
    }

    @Test
    void updateCategoryThrowsException() {
        CategoryDTO categoryDTO = new CategoryDTO();
        when(categoryRepository.findById(categoryDTO.getId())).thenReturn(Optional.empty());

        assertThrows(DataBaseConnectionException.class, () -> categoryService.updateCategory(categoryDTO));
    }

    @Test
    void deleteCategorySuccessfully() {
        Long id = 1L;
        doNothing().when(categoryRepository).deleteById(id);

        assertDoesNotThrow(() -> categoryService.deleteCategory(id));
        verify(categoryRepository, times(1)).deleteById(id);
    }

    @Test
    void deleteCategoryThrowsException() {
        Long id = 1L;
        doThrow(new DataBaseConnectionException()).when(categoryRepository).deleteById(id);

        assertThrows(DataBaseConnectionException.class, () -> categoryService.deleteCategory(id));
    }
}
