package com.realestateapp.realestateapp.services.base;


import com.realestateapp.realestateapp.models.Addresses;

import java.util.List;

public interface AddressesService {
    List<Addresses> findAll();

    Addresses findById(int id);

    void create(Addresses ads) throws Exception;

    void edit(Addresses ads);

    void deleteById(int id) throws Exception;
}
