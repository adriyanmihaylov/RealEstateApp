package com.realestateapp.realestateapp.services.base;

import com.realestateapp.realestateapp.models.Ads;

import java.util.List;

public interface AdsService {
    List<Ads> findAll();

    List<Ads> findLatest5();

    Ads findById(Long id);

    void create(Ads ads);

    void edit(Ads ads);

    void deleteById(Long id) throws Exception;
}