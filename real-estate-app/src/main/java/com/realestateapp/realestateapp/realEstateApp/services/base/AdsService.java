package com.realestateapp.realestateapp.realEstateApp.services.base;

import com.realestateapp.realestateapp.realEstateApp.models.Ads;

import java.util.List;

public interface AdsService {
    List<Ads> findAll();

    List<Ads> findLatest5();

    Ads findById(Long id);

    Ads create(Ads ads);

    Ads edit(Ads ads);

    void deleteById(Long id);
}