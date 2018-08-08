package com.realestateapp.realestateapp.services;

import com.realestateapp.realestateapp.models.Address;
import com.realestateapp.realestateapp.repositories.base.AddressRepository;
import com.realestateapp.realestateapp.services.base.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressServiceImpl implements AddressService {
    private AddressRepository repository;

    AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getAll() {
        return repository.getAll();
    }

    @Override
    public Address getById(int id) {
        return repository.getById(id);
    }

    @Override
    public void create(Address address) {
        List<Address> allAddresses = getAll();

        allAddresses.stream()
                .filter(addressItem -> address.getName().equals(addressItem.getName()))
                .findAny()
                .ifPresent(s -> {
                    System.out.println("Address already exists!");
                    return;
                });

        try {
            repository.create(address);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Address already exists");
        }
    }

    @Override
    public void edit(Address address) {
        repository.update(address);
    }

    @Override
    public void deleteById(int id) {
        repository.delete(id);
    }
}