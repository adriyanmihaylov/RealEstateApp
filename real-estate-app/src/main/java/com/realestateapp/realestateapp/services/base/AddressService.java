package com.realestateapp.realestateapp.services.base;


import com.realestateapp.realestateapp.models.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAll();

    Address findById(long id);

    void create(Address ads) throws Exception;

    void edit(Address ads);

    void deleteById(long id) throws Exception;
}
