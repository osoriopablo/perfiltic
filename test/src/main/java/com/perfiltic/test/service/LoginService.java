package com.perfiltic.test.service;

import java.util.ArrayList;
import java.util.List;

import com.perfiltic.test.dto.UserDto;
import com.perfiltic.test.persistence.models.Users;
import com.perfiltic.test.repository.UsersRepository;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


/**
 * LoginService
 */
@Service
public class LoginService {

    @Autowired
    private Mapper mapper;

    @Autowired
    private UsersRepository repository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Users registerUser(UserDto dto){

        Users newUser = new Users();
        mapper.map(dto,newUser);

        newUser.setPassword( encoder.encode(newUser.getPassword()) );

        try {
            repository.save(newUser);
            return newUser;
        } catch (Exception e) {
            return new Users();
        }

    }

    public List<Users> getUsers(){
        try {
            List<Users> users = repository.findAll();
            return users;
        } catch (Exception e) {
            List<Users> blank = new ArrayList<>();
            return blank;
        }
    }
    
}