package com.perfiltic.test.repository;

import com.perfiltic.test.persistence.models.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UsersRepository
 */
@Transactional
public interface UsersRepository extends JpaRepository<Users,Long> {

	Users findByUsername(String username);

    
}