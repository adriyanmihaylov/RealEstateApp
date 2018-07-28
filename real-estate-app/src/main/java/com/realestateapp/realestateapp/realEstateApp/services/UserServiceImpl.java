package com.realestateapp.realestateapp.realEstateApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.realEstateApp.models.User;
import com.realestateapp.realestateapp.realEstateApp.repositories.base.UserRepository;
import com.realestateapp.realestateapp.realEstateApp.services.base.UserService;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void create(User user) {
        userRepository.create(user);
    }

    @Override
    public User edit(User user) {
        return userRepository.edit(user);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}