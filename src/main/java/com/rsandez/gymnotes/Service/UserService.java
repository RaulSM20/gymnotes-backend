package com.rsandez.gymnotes.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsandez.gymnotes.Entities.User;
import com.rsandez.gymnotes.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
