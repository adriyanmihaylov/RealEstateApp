package com.realestateapp.realestateapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.services.base.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/get={id}")
    public User findById(@PathVariable(value = "id") String idString) {
        return service.findById(Long.parseLong(idString));
    }

    @PostMapping("/delete={id}")
    public void deleteById(@PathVariable(value = "id") String idString) {
        service.deleteById(Long.parseLong(idString));
    }
}