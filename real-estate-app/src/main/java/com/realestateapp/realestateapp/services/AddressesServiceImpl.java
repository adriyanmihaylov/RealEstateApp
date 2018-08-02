package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Addresses;
import com.realestateapp.realestateapp.repositories.base.AddressesRepository;
import com.realestateapp.realestateapp.services.base.AddressesService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressesServiceImpl implements AddressesService {
    AddressesRepository repository;
    AddressesServiceImpl(AddressesRepository repository){
        this.repository = repository;
    }
    @Override
    public List<Addresses> findAll() {
        return repository.listAll();
    }
    @Override
    public Addresses findById(int id) {
        return repository.findById(id);
    }


    @Override
    public void create(Addresses addresses) throws Exception {
        try {
            repository.create(addresses);
        }
        catch (Exception e){
            System.out.println("Address already exists");
        }
    }

    @Override
    public void edit(Addresses addresses) {
        repository.update(addresses);
    }

    @Override
    public void deleteById(int id) {
        try {
            repository.delete(id);
        }catch (Exception e){
            System.out.println("Failed to delete Address with id: " + id);
        }
    }
}
