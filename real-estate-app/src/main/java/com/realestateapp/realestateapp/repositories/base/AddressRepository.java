package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Address;

import java.util.List;

public interface AddressRepository {
    List<Address> listAll();

    Address findById(long id);

    void create(Address address) throws Exception;

    void update(Address address);

    void delete(long id);
}

