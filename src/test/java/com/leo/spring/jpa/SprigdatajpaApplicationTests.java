package com.leo.spring.jpa;

import com.leo.spring.jpa.entity.Product;
import com.leo.spring.jpa.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SprigdatajpaApplicationTests {

    @Autowired
    ApplicationContext context;

    @Test
    public void createProduct() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Product product = new Product();
        product.setId(2L);
        product.setName("Mac");
        product.setDescription("Computer");
        product.setPrice(1200l);

        productRepository.save(product);
    }

    @Test
    public void updateProduct() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        Product product = new Product();
        product.setId(1L);
        product.setName("Mac Pro");
        product.setDescription("Ultra Expensive Computer");
        product.setPrice(1700l);

        productRepository.save(product);
    }

    @Test
    public void findAllProducts() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        productRepository.findAll().forEach(p -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(p.getId());
            stringBuilder.append(" ");
            stringBuilder.append(p.getName());
            stringBuilder.append(" ");
            stringBuilder.append(p.getPrice());
            stringBuilder.append(" ");
            stringBuilder.append(p.getDescription());
            System.out.println(stringBuilder);
        });
    }

    @Test
    public void findByName() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println(productRepository.findByName("Mac"));
    }

    @Test
    public void findByPrice() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println(productRepository.findByPrice(1700L));

    }

    @Test
    public void findByNameAndPrice() {
        ProductRepository productRepository = context.getBean(ProductRepository.class);
        System.out.println(productRepository.findByNameAndPrice("Mac", 1200L));

    }

}

