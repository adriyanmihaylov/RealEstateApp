package com.realestateapp.realestateapp.controllers;

import com.realestateapp.realestateapp.models.Ads;

import org.springframework.beans.factory.annotation.Autowired;

import com.realestateapp.realestateapp.services.base.AdsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ads")
public class AdsController {
    private AdsService adsService;

    @Autowired
    public AdsController(AdsService service) {
        this.adsService = service;
    }

    //WORKING
    @GetMapping(value = "/")
    public List<Ads> findAll() {
        return adsService.findAll();
    }

    //WORKING
    @GetMapping("/get")
    public Ads findById(@RequestParam("id") String stringID) {
        Ads ad = null;
        try {
            ad = adsService.findById((Long.parseLong(stringID)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ad;
    }

    //WORKING, try with POSTMAN or CURL REQUEST
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@RequestParam("id") String idString) {
        try {
            long id = Long.parseLong(idString);
            adsService.deleteById(id);
            return new ResponseEntity<>("Data deleted successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Not FOUND", HttpStatus.NOT_FOUND);
        }
    }

    //WORKING TRY WITH POST with http://localhost:8080/api/ads/create?title=AddNum1&description=Test1
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestParam("title") String title,
                                    @RequestParam("description") String description) {
        //TODO Validation
        try {
            Ads newAd = new Ads(title, description);
            adsService.create(newAd);
            return new ResponseEntity<>("Data created successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Data already exists", HttpStatus.NOT_FOUND);
        }
    }

    //WORKING TRY WITH PUT METHOD with http://localhost:8080/api/ads/update?id=9&title=Ebahgo&description=MamatasiEEBALO
    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<?> update(@RequestParam("id") long id,
                                    @RequestParam(value = "title", required = false) String title,
                                    @RequestParam(value = "description", required = false) String description) {
        //TODO Validation
        try {
            Ads addToUpdate = adsService.findById(id);
            if (description != null) {
                addToUpdate.setDescription(description);
            }
            if (title != null) {
                addToUpdate.setTitle(title);
            }
            adsService.edit(addToUpdate);
            return new ResponseEntity<>("Data updated successfully", HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Data does not exists exists", HttpStatus.NOT_FOUND);
        }
    }
}