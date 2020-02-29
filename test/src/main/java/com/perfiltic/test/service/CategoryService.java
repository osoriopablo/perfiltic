package com.perfiltic.test.service;

import com.perfiltic.test.dto.CategoryDto;
import com.perfiltic.test.persistence.models.Category;
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
        Category newCategory = new Category();
        mapper.map(dto,newCategory);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Users user = usersRepository.findByUsername(authentication.getName());

        newCategory.setUsers(user);

        try {
            repository.save(newCategory);
            return newCategory;
        } catch (Exception e) {
            return new Category();
        }
    }

    
}