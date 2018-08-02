package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.User;

import java.util.List;

public interface UserRepository {
    List<User> getAll();

    User findById(Long id);

   boolean create(User user);

    boolean update(User user);

    boolean deleteById(long id);

}
