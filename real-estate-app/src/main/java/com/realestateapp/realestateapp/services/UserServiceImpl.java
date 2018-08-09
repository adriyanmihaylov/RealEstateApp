package com.realestateapp.realestateapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.repositories.base.UserRepository;
import com.realestateapp.realestateapp.services.base.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getById(int id) {
        return userRepository.getById(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public boolean create(User user) {
        return userRepository.create(user);
    }

    @Override
    public boolean update(User user) {
        return userRepository.update(user);
    }

    @Override
    public boolean deleteById(int id) {
        return userRepository.deleteById(id);
    }

    @Override
    public boolean checkIfUsernameIsPresent(String username) {
        return userRepository.getByUsername(username) != null;
    }

    @Override
    public boolean checkIfEmailIsPresent(String email) {
        return userRepository.getByEmail(email) != null;
    }
}