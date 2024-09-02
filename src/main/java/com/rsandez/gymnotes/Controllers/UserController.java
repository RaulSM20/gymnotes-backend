package com.rsandez.gymnotes.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsandez.gymnotes.Entities.User;
import com.rsandez.gymnotes.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

     @Autowired
    private UserService service;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.getAllUsers();
    }
}
