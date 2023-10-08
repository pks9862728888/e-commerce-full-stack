package com.demo.ecommerce.services;

import com.demo.ecommerce.entity.Product;
import com.demo.ecommerce.exceptions.DbException;
import com.demo.ecommerce.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DbService {

    @Autowired
    private ProductRepository productRepository;

    public boolean productExists(String movieName) {
        return productRepository.existsByName(movieName);
    }

    public Product saveProduct(Product product) throws DbException {
        try {
            log.info("Saving product: {}", product.getName());
            product = productRepository.save(product);
            log.info("Saved product: {} id: {}", product.getName(), product.getId());
            return product;
        } catch (Exception e) {
            throw new DbException(e);
        }
    }

    public Page<Product> getAllProducts(PageRequest pageRequest) {
        return productRepository.findAll(pageRequest);
    }

    public Page<Product> getAllProductsByName(String productName, PageRequest pageRequest) {
        log.info("Get all products containing name:: {}", productName);
        return productRepository.findAllByNameContaining(productName, pageRequest);
    }
}
