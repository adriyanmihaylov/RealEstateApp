package com.realestateapp.realestateapp.realEstateApp.controllers;

import com.realestateapp.realestateapp.realEstateApp.models.Ads;
import com.realestateapp.realestateapp.realEstateApp.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.realestateapp.realestateapp.realEstateApp.services.base.AdsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/api/ads")
public class AdsController {
    private AdsService adsService;

    @Autowired
    public AdsController(AdsService service) {
        this.adsService = service;
    }
//        @GetMapping("/")
//    public List<Ads> getAll(){
//       return adsService.findAll();
//        }
    @GetMapping("/get")
    public Ads findById(@RequestParam(value = "id") String id){
        return adsService.findById(Long.parseLong(id));
    }
    @PostMapping("/delete")
    public void delete(@RequestParam(value = "id") String id){
        adsService.deleteById(Long.parseLong(id));
    }
//    @GetMapping("/")
//    public String index(){
//        return "ads";
//    }
}
