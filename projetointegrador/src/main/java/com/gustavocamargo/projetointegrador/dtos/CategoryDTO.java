package com.gustavocamargo.projetointegrador.dtos;

import com.gustavocamargo.projetointegrador.entities.Category;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotNull
    @Size(min = 1 , max = 20)
    private String name;

    public CategoryDTO (Category category){
        this.id = category.getId();
        this.name = category.getName();
    }

}
