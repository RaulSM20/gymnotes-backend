package com.rsandez.gymnotes.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rsandez.gymnotes.Entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {
    Optional<User> findByUsername(String username);
    
}
