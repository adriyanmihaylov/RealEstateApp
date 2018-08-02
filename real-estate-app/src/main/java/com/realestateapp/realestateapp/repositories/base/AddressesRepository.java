package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Addresses;

import java.util.List;

public interface AddressesRepository {
    List<Addresses> listAll();

    Addresses findById(int id);

    void create(Addresses address) throws Exception;

    void update(Addresses addresses);

    void delete(int id);
}

