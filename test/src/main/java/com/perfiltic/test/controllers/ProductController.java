package com.perfiltic.test.controllers;

import java.util.List;

import com.perfiltic.test.dto.ProductDto;
import com.perfiltic.test.persistence.models.Product;
import com.perfiltic.test.service.CategoryService;
import com.perfiltic.test.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProductController
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping()
    public List<Product> getProducts(@RequestParam String category ) {
        return service.getProducts(category);
    }
    
    @PostMapping()
    public Product createProduct(@RequestBody ProductDto entity) {
        
        return service.createProduct(entity);
    }
    
}