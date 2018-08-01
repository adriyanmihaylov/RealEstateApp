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
    @GetMapping("/")
    public List<Ads> findAll() {
        return adsService.findAll();
    }
    //WORKING
    @GetMapping("/get")
    public Ads findById(@RequestParam("id") String stringID) {
        return adsService.findById((Long.parseLong(stringID)));
    }


    //Working, try with POSTMAN or CURL REQUEST
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteById(@RequestParam("id") long id) {
            try {
                adsService.deleteById(id);
                return new ResponseEntity<>("Data deleted successfully", HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>("Not FOUND", HttpStatus.NOT_FOUND);
            }
    }
    //WORKING TRY IN THE BROWSER with http://localhost:8080/api/ads/create?title=AddNum1 &description=Test1
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<?> create(@RequestParam("title") String title,
                                    @RequestParam("description") String description){
        //TODO Validation

        try {
            Ads newAdd = new Ads(title, description);
            adsService.create(newAdd);
            return new ResponseEntity<>("Data created successfully", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Data already exists", HttpStatus.NOT_FOUND);
        }
    }
}