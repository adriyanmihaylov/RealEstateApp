package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.Property;

import java.util.List;

public interface PropertiesService {
    List<Property> getAll();

    Property getById(int id);

    boolean create(Property property);

    boolean update(Property property);

//    boolean deleteById(long id) throws Exception;
//
    List<Property> find(String address, String material,
                        String type, String priceFrom, String priceTo, String baths, String bedrooms, String size);

    List<Property> findLatestSix();

//    boolean deleteById(int id) throws Exception;
}