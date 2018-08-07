package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(long id);

    boolean create(User user);

    boolean update(User user);

    boolean deleteById(long id);

    List<User> search() throws InterruptedException;
}