package com.realestateapp.realestateapp.realEstateApp.controllers;

import com.realestateapp.realestateapp.realEstateApp.models.Ads;
import com.realestateapp.realestateapp.realEstateApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.realestateapp.realestateapp.realEstateApp.services.base.AdsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/ads")
public class AdsController {
    private AdsService adsService;

    @Autowired
    public AdsController(AdsService service) {
        this.adsService = service;
    }

    @GetMapping("/get")
    public Ads findById(@RequestParam(value = "id") String idString) {
        return adsService.findById(Long.parseLong(idString));
    }

    @PostMapping("/delete")
    public void delete(@RequestParam(value = "id") String idString) {
        adsService.deleteById(Long.parseLong(idString));
    }
}