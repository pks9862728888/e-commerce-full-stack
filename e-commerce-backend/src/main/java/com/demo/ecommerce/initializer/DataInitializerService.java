package com.demo.ecommerce.initializer;

import com.demo.ecommerce.datastore.ProductDataStore;
import com.demo.ecommerce.entity.Product;
import com.demo.ecommerce.exceptions.DbException;
import com.demo.ecommerce.services.DbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DataInitializerService {

    @Autowired
    private DbService dbService;

    @Autowired
    private ProductDataStore productDataStore;

    public void initProducts() {
        log.info("Initializing products data...");
        productDataStore.getMovies()
                .stream()
                .filter(m -> !dbService.productExists(m.getName()))
                .forEach(this::saveProductDontFail);
        log.info("Products Data initialized!");
    }

    private void saveProductDontFail(Product product) {
        try {
            dbService.saveProduct(product);
        } catch (DbException e) {
            log.error("Exception occurred while saving product: {} Exception: {}",
                    product.getName(), e.getMessage());
        }
    }
}
