package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Property;
import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.repositories.base.PropertyRepository;
import com.realestateapp.realestateapp.services.base.PropertiesService;

import java.util.List;
@Service
public class PropertiesServiceImpl implements PropertiesService {

    private PropertyRepository repository;

    public PropertiesServiceImpl(PropertyRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Property> findAll() {
        return repository.getAll();
    }

    @Override
    public Property findById(long id) {
        return repository.findById(id);
    }

    @Override
    public boolean create(Property property) {
        return repository.create(property);
    }

    @Override
    public boolean update(Property ad) {
        return repository.update(ad);
    }

    @Override
    public boolean deleteById(long id) {
        return repository.deleteById(id);
    }

//    @Override
//    public List<Property> search(String address, String material, String type, int priceFrom, int priceTo, int baths, int bedrooms) {
//        return null;
//    }

    @Override
    public List<Property> findLatestSix() {
        List<Property> allProperties = repository.getAll();
        if (allProperties.size() < 6) {
            return allProperties;
        }
        return allProperties.subList(allProperties.size() - 6, allProperties.size());
    }
}