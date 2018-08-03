package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Estate;
import com.realestateapp.realestateapp.repositories.base.EstateRepository;
import com.realestateapp.realestateapp.services.base.EstateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstateServiceImpl implements EstateService {

    private EstateRepository repository;

    public EstateServiceImpl(EstateRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Estate> getAll() {
        return repository.getAll();
    }

    @Override
    public Estate getById(long id) {
        return repository.getById(id);
    }

    @Override
    public boolean create(Estate estate) {
        return repository.create(estate);
    }

    @Override
    public boolean update(Estate estate) {
        return repository.update(estate);
    }

    @Override
    public boolean deleteById(long id) {
        return repository.deleteById(id);
    }
}
