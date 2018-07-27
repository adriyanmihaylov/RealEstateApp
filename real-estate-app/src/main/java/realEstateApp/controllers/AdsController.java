package realEstateApp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import realEstateApp.services.base.AdsService;

@Controller
public class AdsController {
    private AdsService adsService;

    @Autowired
    public AdsController(AdsService service) {
        this.adsService = service;
    }
}
