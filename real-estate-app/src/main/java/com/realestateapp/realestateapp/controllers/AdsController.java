package com.realestateapp.realestateapp.controllers;

import com.realestateapp.realestateapp.models.Ads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.realestateapp.realestateapp.services.base.AdsService;
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

    @GetMapping("/")
    public List<Ads> findAll() {
        return adsService.findAll();
    }

    @GetMapping("/get={id}")
    public Ads findById(@PathVariable(value = "id") String idString) {
        return adsService.findById(Long.parseLong(idString));
    }

    //TODO
    /**Doesn't work*/
    
    @PostMapping(value = "/delete={id}")
    public void deleteById(@PathVariable(value = "id") String idString) {
        adsService.deleteById(Long.parseLong(idString));
    }
}