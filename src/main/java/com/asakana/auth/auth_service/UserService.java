package com.asakana.auth.auth_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Integer id, User userDetails) {
        return userRepository.findById(id).map(user -> {
            user.setEmail(userDetails.getEmail());
            user.setPasswordHash(userDetails.getPasswordHash());
            user.setUpdatedAt(userDetails.getUpdatedAt());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
} 