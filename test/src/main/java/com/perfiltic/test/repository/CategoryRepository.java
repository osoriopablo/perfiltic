package com.perfiltic.test.repository;

import com.perfiltic.test.persistence.models.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * CategoryRepository
 */
@Transactional
public interface CategoryRepository extends JpaRepository<Category,Long>{

    Category findByName(String name);

    
}