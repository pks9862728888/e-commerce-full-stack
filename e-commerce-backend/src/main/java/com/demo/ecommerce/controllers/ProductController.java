package com.demo.ecommerce.controllers;

import com.demo.ecommerce.entity.Product;
import com.demo.ecommerce.services.DbService;
import io.micrometer.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/v1/products")
public class ProductController extends GenericExceptionHandler {

    @Autowired
    private DbService dbService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAllMovies(
            @RequestParam("page") int pageNo, @RequestParam("size") int pageSize,
            @RequestParam(required = false, name = "productName") String productName,
            @RequestParam(required = false, name = "sort") String sortingFieldName,
            @RequestParam(required = false, name = "direction") Sort.Direction sortDirection) {
        // Init to default values if sorting is not set
        sortingFieldName = StringUtils.isEmpty(sortingFieldName) ? "id" : sortingFieldName;
        sortDirection = Objects.isNull(sortDirection) ? Sort.Direction.ASC : sortDirection;

        // Create page request and return result
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, Sort.by(sortDirection, sortingFieldName));
        if (StringUtils.isEmpty(productName)) {
            return new ResponseEntity<>(dbService.getAllProducts(pageRequest), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(dbService.getAllProductsByName(productName, pageRequest), HttpStatus.OK);
        }
    }
}
