package com.rsandez.gymnotes.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsandez.gymnotes.Entities.Routine;
import com.rsandez.gymnotes.Entities.User;
import com.rsandez.gymnotes.Repositories.RoutineRepository;
import com.rsandez.gymnotes.Repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoutineRepository routineRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void followRoutine(Integer userId, Integer routineId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Routine> routineOptional = routineRepository.findById(routineId);

        if (userOptional.isPresent() && routineOptional.isPresent()) {
            User user = userOptional.get();
            Routine routine = routineOptional.get();
            user.getRoutines().add(routine);
            userRepository.save(user);
        } else {
            throw new RuntimeException("User or Routine not found");
        }
    }

    public List<Routine> getRoutinesByUserId(Integer userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            return userOptional.get().getRoutines();
        } else {
            throw new RuntimeException("User not found");
        }
    }
}
