package com.realestateapp.realestateapp.controllers;

import com.realestateapp.realestateapp.models.Estate;
import com.realestateapp.realestateapp.services.base.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/estates")
public class EstateController {

    private EstateService service;

    @Autowired
    public EstateController(EstateService service) {
        this.service = service;
    }

    @RequestMapping("/")
    public List<Estate> getAll() {
        List<Estate> allEstates = new ArrayList<>();
        try {
            allEstates = service.getAll();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allEstates;
    }

    @GetMapping("/get")
    public Estate getById(@RequestParam("id") String idString) {
        Estate estate = null;
        try {
            estate = service.getById(Long.parseLong(idString));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return estate;
    }
}