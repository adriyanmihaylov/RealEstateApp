package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> getAll();

    Address getById(int id);

    void create(Address address) throws Exception;

    void update(Address address);

    void delete(int id);
}