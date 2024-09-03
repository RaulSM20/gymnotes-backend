package com.rsandez.gymnotes.Controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rsandez.gymnotes.Entities.Routine;
import com.rsandez.gymnotes.Entities.User;
import com.rsandez.gymnotes.Service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

     @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/{userId}/routines/{routineId}")
    public ResponseEntity<String> followRoutine(@PathVariable Integer userId, @PathVariable Integer routineId) {
        userService.followRoutine(userId, routineId);
        return ResponseEntity.ok("Routine followed successfully.");
    }

    @GetMapping("/{userId}/routines")
    public ResponseEntity<List<Routine>> getUserRoutines(@PathVariable Integer userId) {
        List<Routine> routines = userService.getRoutinesByUserId(userId);
        return ResponseEntity.ok(routines);
    }
}
