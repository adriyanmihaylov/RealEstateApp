package com.realestateapp.realestateapp.realEstateApp.controllers;

import com.realestateapp.realestateapp.realEstateApp.models.Ads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.realestateapp.realestateapp.realEstateApp.models.User;
import com.realestateapp.realestateapp.realEstateApp.services.base.UserService;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/users")
public class UserController {
    private UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User("username", "Yani", "Drenchev", "123123", new Ads()));
        return users;
    }

    @GetMapping("/get/id")
    public User findById(@RequestParam(value = "id") String id) {
        return service.findById(Long.parseLong(id));
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/delete")
    public void delete(@RequestParam(value = "id") String id) {
        service.deleteById(Long.parseLong(id));
    }
}