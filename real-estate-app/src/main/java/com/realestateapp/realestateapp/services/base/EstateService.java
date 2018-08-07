package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.Estate;

import java.util.List;

public interface EstateService {
    List<Estate> getAll();

    Estate getById(long id);

    boolean create(Estate estate);

    boolean update(Estate estate);

    boolean deleteById(long id);
}

