package com.gustavocamargo.projetointegrador.repositories;

import com.gustavocamargo.projetointegrador.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository <Product , Long> {

}
