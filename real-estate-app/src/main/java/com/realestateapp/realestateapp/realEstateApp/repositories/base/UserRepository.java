package com.realestateapp.realestateapp.realEstateApp.repositories.base;

import com.realestateapp.realestateapp.realEstateApp.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Long id);

    void create(User user);

    User edit(User user);

    void deleteById(Long id);
}
