package com.realestateapp.realestateapp.controllers;

import com.realestateapp.realestateapp.models.*;

import com.realestateapp.realestateapp.viewModels.PropertyViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import com.realestateapp.realestateapp.services.base.PropertiesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PropertiesController {
    @Autowired
    private PropertiesService service;



    //WORKING
    @GetMapping(value = "/properties")
    public List<PropertyViewModel> findAll() {
        return service.getAll()
                .stream()
                .map(PropertyViewModel::fromModel)
                .collect(Collectors.toList());
    }

    //WORKING
    @GetMapping("/properties/get")
    public Property findById(@RequestParam("id") String stringID) {
        Property property = null;
        try {
            property = service.getById((Integer.parseInt(stringID)));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return property;
    }


//    //WORKING TRY WITH POST with http://localhost:8080/api/posts/create?title=AddNum1&description=Test1
//    @RequestMapping(value = "/properties/create", method = RequestMethod.POST)
//    public ResponseEntity<?> create(@RequestParam("title") String title,
//                                    @RequestParam(value = "description", required = false) String description,
//                                    @RequestParam("address") String address,
//                                    @RequestParam("material") String material,
//                                    @RequestParam("type") String type,
//                                    @RequestParam("price") int price,
//                                    @RequestParam("baths") int baths,
//                                    @RequestParam("bedrooms") int bedrooms) {
//        Address address1 = new Address(address);
//        Material material1 = new Material(material);
//        Type type1 = new Type(type);
//        Estate newEstate = new Estate(address1, material1, type1, price, baths, bedrooms);
//        estateService.create(newEstate);
//        Property post = new Property(title, description, newEstate);
//
//        try {
//            if (service.create(post)) {
//                return new ResponseEntity<>("Property created successfully", HttpStatus.ACCEPTED);
//            }
//
//            return new ResponseEntity<>("Property already exists", HttpStatus.NOT_FOUND);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error " + e.getMessage() + "!", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

//    //WORKING TRY WITH PUT METHOD with http://localhost:8080/api/posts/update?id=9&title=Updated post&description=Updated Description
//    @RequestMapping(value = "properties/update", method = RequestMethod.PUT)
//    public ResponseEntity<?> update(@RequestParam("id") String idString,
//                                    @RequestParam(value = "title", required = false) String title,
//                                    @RequestParam(value = "description", required = false) String description) {
//        System.out.println(title);
//        try {
//            Property property = service.getById(Long.parseLong(idString));
//
//            if (property == null) {
//                return new ResponseEntity<>("Property not found", HttpStatus.NOT_FOUND);
//            }
//
//            if (description != null) {
//                property.setDescription(description);
//                service.update(property);
//            }
//            if (title != null) {
//                property.setTitle(title);
//                service.update(property);
//            }
//
//            return new ResponseEntity<>("Property updated successfully", HttpStatus.ACCEPTED);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error " + e.getMessage() + "!", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    //WORKING, try with POSTMAN or CURL REQUEST
//    @RequestMapping(value = "/properties/delete", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteById(@RequestParam("id") String idString) {
//        try {
//            if (service.deleteById(Long.parseLong(idString))) {
//                return new ResponseEntity<>("Property deleted successfully", HttpStatus.ACCEPTED);
//            } else {
//                return new ResponseEntity<>("Property NOT FOUND! ID=" + idString, HttpStatus.NOT_FOUND);
//            }
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error " + e.getMessage() + "!", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public String search(@RequestParam(value = "address", required = false, defaultValue = "%") String address,
                             @RequestParam(value = "material", required = false, defaultValue = "%") String material,
                             @RequestParam(value = "type", required = false ,defaultValue = "%") String type,
                             @RequestParam(value = "price", required = false, defaultValue = "0") String priceFrom,
                             @RequestParam(value = "price", required = false, defaultValue = Integer.MAX_VALUE + "") String priceTo,
                             @RequestParam(value = "baths", required = false, defaultValue = "%") String baths,
                             @RequestParam(value = "bedrooms", required = false, defaultValue = "%") String bedrooms,
                         @RequestParam(value = "size", required = false, defaultValue = "%") String size,
                         Model model) {
        model.addAttribute("view", "properties/properties-list");
        List<Property> result;
//        result = service.find(address, material, type, priceFrom , priceTo ,
//                baths, bedrooms, size);
        result = service.getAll();
        model.addAttribute("result", result);
        return "base";
   }
}