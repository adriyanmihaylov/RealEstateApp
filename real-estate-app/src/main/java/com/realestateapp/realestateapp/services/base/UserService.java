package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(Long id);

    void create(User user);

    void edit(User user);

    void deleteById(Long id);
}