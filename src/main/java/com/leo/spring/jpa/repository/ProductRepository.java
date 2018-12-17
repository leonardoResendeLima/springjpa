package com.leo.spring.jpa.repository;

import com.leo.spring.jpa.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findByName(String name);

    List<Product> findByPrice(Long price);

    List<Product> findByNameAndPrice(String name, Long price);

    Optional<Product> findById(Long id);
}
