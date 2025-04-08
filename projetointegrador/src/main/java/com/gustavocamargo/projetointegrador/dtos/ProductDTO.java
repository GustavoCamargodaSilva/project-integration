package com.gustavocamargo.projetointegrador.dtos;

import com.gustavocamargo.projetointegrador.entities.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private String imageUrl;

    private List<CategoryDTO> categories = new ArrayList<>();
}
