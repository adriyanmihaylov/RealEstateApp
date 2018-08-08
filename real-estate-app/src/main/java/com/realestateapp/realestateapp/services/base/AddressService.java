package com.realestateapp.realestateapp.services.base;


import com.realestateapp.realestateapp.models.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAll();

    Address getById(int id);

    void create(Address ads);

    void edit(Address ads);

    void deleteById(int id);
}
