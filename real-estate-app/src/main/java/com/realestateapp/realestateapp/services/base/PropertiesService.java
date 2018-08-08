package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.Property;

import java.util.List;

public interface PropertiesService {
    List<Property> getAll();

    Property getById(int id);

    boolean create(Property property);

    boolean update(Property property);

    boolean deleteById(int id) throws Exception;
}