package com.perfiltic.test.service;

import java.util.List;

import com.perfiltic.test.dto.CategoryDto;
import com.perfiltic.test.persistence.models.Category;
import com.perfiltic.test.persistence.models.Product;
import com.perfiltic.test.persistence.models.Users;
import com.perfiltic.test.repository.CategoryRepository;
import com.perfiltic.test.repository.UsersRepository;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * CategoryService
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private Mapper mapper;

    public Category createCategory(CategoryDto dto){
        Category newProduct = new Category();
        mapper.map(dto,newProduct);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findByUsername(authentication.getName());

        newProduct.setUsers(user);

        try {
            repository.save(newProduct);
            return newProduct;
        } catch (Exception e) {
            return new Category();
        }
    }

	public Category getProducts(String categoryName) {
		try {
            return repository.findByName(categoryName);
        } catch (Exception e) {
            return new Category();
        }
	}

    
}