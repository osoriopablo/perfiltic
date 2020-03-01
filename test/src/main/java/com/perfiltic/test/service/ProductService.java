package com.perfiltic.test.service;

import java.util.List;
import java.util.Optional;

import com.perfiltic.test.dto.ProductDto;
import com.perfiltic.test.persistence.models.Category;
import com.perfiltic.test.persistence.models.Product;
import com.perfiltic.test.persistence.models.Users;
import com.perfiltic.test.repository.CategoryRepository;
import com.perfiltic.test.repository.ProductRepository;
import com.perfiltic.test.repository.UsersRepository;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * ProductService
 */
@Service
public class ProductService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private ProductRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public Product createProduct(ProductDto dto){
        Product newProduct = new Product();
        mapper.map(dto,newProduct);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Users user = usersRepository.findByUsername(authentication.getName());
        Optional<Category> optional = categoryRepository.findById(new Long(dto.getCategoryId()));

        Category category = optional.get();

        newProduct.setUsers(user);
        newProduct.setCategories(category);

        try {
            repository.save(newProduct);
            return newProduct;
        } catch (Exception e) {
            return new Product();
        }
    }

    public Product getProduct(Long id){

        Optional<Product> optional = repository.findById(id);

        return optional.get();
    }

    
}