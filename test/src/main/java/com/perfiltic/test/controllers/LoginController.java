package com.perfiltic.test.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import javax.validation.Valid;

import com.perfiltic.test.dto.UserDto;
import com.perfiltic.test.persistence.models.Users;
import com.perfiltic.test.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



/**
 * LoginController
 */
@RestController
@RequestMapping("users")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping()
    public Users postMethodName(@Valid @RequestBody UserDto entity) {
        
        return loginService.registerUser(entity);
    }

    @GetMapping()
    public List<Users> getMethodName() {
        return loginService.getUsers();
    }
    
    
}