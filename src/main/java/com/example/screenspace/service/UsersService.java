package com.example.screenspace.service;

import com.example.screenspace.model.User;
import com.example.screenspace.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<User> getUserById(Integer userId) {
        return usersRepository.findById(userId);
    }

    public User createUser(User user) {
        return usersRepository.save(user);
    }

    public User updateUser(Integer userId, User updatedUser) {
        Optional<User> existingUser = usersRepository.findById(userId);
        if (existingUser.isPresent()) {
            updatedUser.setId(userId);
            return usersRepository.save(updatedUser);
        }
        return null;
    }

    public boolean deleteUser(Integer userId) {
        Optional<User> existingUser = usersRepository.findById(userId);
        if (existingUser.isPresent()) {
            usersRepository.delete(existingUser.get());
            return true;
        }
        return false;
    }
}
