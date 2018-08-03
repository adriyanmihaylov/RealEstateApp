package com.realestateapp.realestateapp.controllers;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.realestateapp.realestateapp.models.User;
import com.realestateapp.realestateapp.services.base.UserService;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.ws.http.HTTPException;
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

    /**
     * http://localhost:8080/api/users/create?username=TestUser&password=123456&email=testUser@gmail.com&firstName=TestFirstName&lastName=TestSecondName
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    @RequestParam("email") String email,
                                    @RequestParam("firstName") String firstName,
                                    @RequestParam("lastName") String lastName) {
        try {
            User user = new User(username, password,email, firstName, lastName);
            if (service.create(user)) {
                return new ResponseEntity<>("User created successfully", HttpStatus.ACCEPTED);
            }

            return new ResponseEntity<>("User already exists", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error " + e.getMessage() + "!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * TEST WITH http://localhost:8080/api/users/update?id=8&firstName=UpdatedFirstName&lastName=UpdatedSecondName
     */
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestParam("id") String id,
                                    @RequestParam(value = "email", required = false) String email,
                                    @RequestParam(value = "firstName", required = false) String firstName,
                                    @RequestParam(value = "lastName", required = false) String lastName) {
        try {
            User user = service.findById(Long.parseLong(id));

            if (user == null) {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }

            if(email != null) {
                user.setEmail(email);
            }

            if (firstName != null) {
                user.setFirstName(firstName);
            }

            if (lastName != null) {
                user.setLastName(lastName);
            }

            service.update(user);
            return new ResponseEntity<>("User updated successfully", HttpStatus.ACCEPTED);

        } catch (Exception e) {
            return new ResponseEntity<>("Error " + e.getMessage() + "!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * TEST WITH http://localhost:8080/api/users/delete?id=9
     */

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@RequestParam("id") String idString) {
        try {
            if (service.deleteById(Long.parseLong(idString))) {
                return new ResponseEntity<>("User deleted successfully", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("USER NOT FOUND! ID=" + idString, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Error " + e.getMessage() + "!", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}