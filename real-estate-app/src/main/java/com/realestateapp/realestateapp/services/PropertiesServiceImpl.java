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
    public List<Property> getAll() {
        return repository.getAll();
    }

    @Override
    public Property getById(int id) {
        return repository.getById(id);
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
    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }
}