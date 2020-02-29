package com.perfiltic.test.repository;

import com.perfiltic.test.persistence.models.Product;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ProductRepository
 */
public interface ProductRepository extends JpaRepository<Product,Long> {

    
}