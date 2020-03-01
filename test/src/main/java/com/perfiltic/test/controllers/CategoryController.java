package com.perfiltic.test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.perfiltic.test.dto.CategoryDto;
import com.perfiltic.test.persistence.models.Category;
import com.perfiltic.test.persistence.models.Product;
import com.perfiltic.test.service.CategoryService;
import com.perfiltic.test.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




/**
 * CategoryController
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping()
    public String test() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "IM THE CATEGORY LOGGED IN " + authentication.getName();
    }
    
    @PostMapping()
    public Category createCategory(@RequestBody CategoryDto entity) {
        
        return service.createCategory(entity);
    }

    @GetMapping(value="{categoryName}")
    public Category getProductList(@PathVariable("categoryName") String categoryName) {
        return service.getProducts(categoryName);
    }
    


    
    
}