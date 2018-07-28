package com.realestateapp.realestateapp.realEstateApp.services.base;

import com.realestateapp.realestateapp.realEstateApp.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void create(User user);

    User edit(User user);

    void deleteById(Long id);
}