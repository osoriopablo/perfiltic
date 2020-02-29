package com.perfiltic.test.service;

import static java.util.Collections.emptyList;

import com.perfiltic.test.persistence.models.Users;
import com.perfiltic.test.repository.UsersRepository;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService
 */
@Service
public class UsersDetailsService implements UserDetailsService {

	private UsersRepository repository;

	public UsersDetailsService(UsersRepository repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = repository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), emptyList());
	}
}