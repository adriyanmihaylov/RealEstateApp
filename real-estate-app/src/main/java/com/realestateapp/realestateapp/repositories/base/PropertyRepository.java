package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Property;

import java.util.List;

public interface PropertyRepository {
    List<Property> getAll();

    Property getById(int id);

    boolean create(Property newAd);

    boolean update(Property ad);

<<<<<<< HEAD
    boolean deleteById(long id);

    List<Property> find(String address, String material,
                        String type, String priceFrom, String priceTo, String baths, String bedrooms, String size);
=======
    boolean deleteById(int id);
>>>>>>> e0f6f64181884c78295a324626900e4ba1b8e4bb
}
