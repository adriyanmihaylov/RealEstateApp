package com.realestateapp.realestateapp.controllers;

import com.realestateapp.realestateapp.models.Post;

import org.springframework.beans.factory.annotation.Autowired;

import com.realestateapp.realestateapp.services.base.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private PostService service;

    @Autowired
    public PostController(PostService service) {
        this.service = service;
    }

    //WORKING
    @GetMapping(value = "/")
    public List<Post> findAll() {
        return service.findAll();
    }

    //WORKING
    @GetMapping("/get")
    public Post findById(@RequestParam("id") String stringID) {
        Post ad = null;
        try {
            ad = service.findById((Long.parseLong(stringID)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ad;
    }

    //WORKING TRY WITH POST with http://localhost:8080/api/posts/create?title=AddNum1&description=Test1
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestParam("title") String title,
                                    @RequestParam("description") String description) {
        try {
            Post newAd = new Post(title, description);
            service.create(newAd);
            return new ResponseEntity<>("Data created successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Data already exists", HttpStatus.NOT_FOUND);
        }
    }

    //WORKING TRY WITH PUT METHOD with http://localhost:8080/api/posts/update?id=9&title=Updated post&description=Updated Description
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestParam("id") String idString,
                                    @RequestParam(value = "title", required = false) String title,
                                    @RequestParam(value = "description", required = false) String description) {
        //TODO Validation
        try {
            Post addToUpdate = service.findById(Long.parseLong(idString));
            if (description != null) {
                addToUpdate.setDescription(description);
            }
            if (title != null) {
                addToUpdate.setTitle(title);
            }
            service.update(addToUpdate);
            return new ResponseEntity<>("Data updated successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Data does not exists", HttpStatus.NOT_FOUND);
        }
    }

    //WORKING, try with POSTMAN or CURL REQUEST
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@RequestParam("id") String idString) {

        //TODO (not sure) check if post is null (in repository we are checking that)
        try {
            service.deleteById(Long.parseLong(idString));
            return new ResponseEntity<>("Data deleted successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Not FOUND", HttpStatus.NOT_FOUND);
        }
    }
}