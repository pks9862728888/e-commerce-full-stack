package com.demo.ecommerce.datastore;

import com.demo.ecommerce.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDataStore {

    private static final List<Product> PRODUCTS = new ArrayList<>();

    static {
        PRODUCTS.add(Product.builder().name("POCO F5").build());
        PRODUCTS.add(Product.builder().name("POCO X5 Pro").build());
        PRODUCTS.add(Product.builder().name("POCO X5").build());
        PRODUCTS.add(Product.builder().name("POCO C55").build());
        PRODUCTS.add(Product.builder().name("Poco X5 Pro").build());
        PRODUCTS.add(Product.builder().name("Asus Zenfone Max Pro M1").build());
        PRODUCTS.add(Product.builder().name("Asus Zenfone Max Pro M2").build());
        PRODUCTS.add(Product.builder().name("Asus Zenfone 10").build());
        PRODUCTS.add(Product.builder().name("OnePlus 9RT 5G").build());
        PRODUCTS.add(Product.builder().name("OnePlus 9 Pro 5G").build());
        PRODUCTS.add(Product.builder().name("OnePlus 9 5G").build());
        PRODUCTS.add(Product.builder().name("OnePlus 9R 5G").build());
        PRODUCTS.add(Product.builder().name("OnePlus Nord CE 5G").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi 12 5G").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi Note 12 Pro 5G").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi Note 12").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi 12").build());
        PRODUCTS.add(Product.builder().name("Xiaomi 13 Pro").build());
        PRODUCTS.add(Product.builder().name("Xiaomi 12 Pro 5G").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi Note 12 4G").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi 12 5G 8GB RAM").build());
        PRODUCTS.add(Product.builder().name("Xiaomi Redmi 12 5G 6GB RAM").build());
        PRODUCTS.add(Product.builder().name("iPhone 15 Pro").build());
        PRODUCTS.add(Product.builder().name("iPhone 15").build());
        PRODUCTS.add(Product.builder().name("iPhone 14").build());
        PRODUCTS.add(Product.builder().name("iPhone 13").build());
        PRODUCTS.add(Product.builder().name("iPhone SE").build());
        PRODUCTS.add(Product.builder().name("Realme 11 Pro Plus").build());
        PRODUCTS.add(Product.builder().name("Realme 11x 5G").build());
        PRODUCTS.add(Product.builder().name("Realme GT 2 Pro 5G").build());
        PRODUCTS.add(Product.builder().name("Realme 11 Pro").build());
        PRODUCTS.add(Product.builder().name("Realme GT 5").build());
    }

    public List<Product> getMovies() {
        return new ArrayList<>(PRODUCTS);
    }
}
