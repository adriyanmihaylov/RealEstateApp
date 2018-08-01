package com.realestateapp.realestateapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/get")
    public User findById(@RequestParam("id") String stringID) {
        User user = null;
        try {
            user = service.findById((Long.parseLong(stringID)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //WORKING  http://localhost:8080/api/users/create?username=Ginka&password=123456&firstName=Ginka&lastName=Shikerova
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName) {
        try {
            User user = new User(username, password, firstName, lastName);
            service.create(user);
            return new ResponseEntity<>("User created successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("User already exists", HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@RequestParam("id") String idString) {
        try {
            long id = Long.parseLong(idString);
            service.deleteById(id);
            return new ResponseEntity<>("User deleted successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("User NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }
}