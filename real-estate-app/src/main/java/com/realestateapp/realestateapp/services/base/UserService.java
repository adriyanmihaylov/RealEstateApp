package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(int id);

    boolean create(User user);

    boolean update(User user);

    boolean deleteById(int id);
}