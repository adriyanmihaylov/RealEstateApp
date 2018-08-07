package com.realestateapp.realestateapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.repositories.base.UserRepository;
import com.realestateapp.realestateapp.services.base.UserService;

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
        return userRepository.getAll();
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
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
    public boolean deleteById(long id) {
        return userRepository.deleteById(id);
    }

    @Override
    public List<User> search() throws InterruptedException {
<<<<<<< HEAD
        return userRepository.search();
=======
        return null;
>>>>>>> c6aa7d3242afd0a32f8d456ff0ab8a571404a50a
    }
}