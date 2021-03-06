package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Property;

import java.util.List;

public interface PropertyRepository {
    List<Property> getAll();

    Property getById(int id);

    boolean create(Property newAd);

    boolean update(Property ad);

    boolean deleteById(long id);

    List<Property> find(String address, String material,
                        String type, String sizeFrom, String sizeTo, String baths, String bedrooms);

    boolean deleteById(int id);

}
