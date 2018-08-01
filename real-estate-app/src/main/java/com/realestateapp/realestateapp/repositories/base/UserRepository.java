package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(Long id);

    void create(User user);

    void edit(User user);

    void deleteById(Long id);
}
