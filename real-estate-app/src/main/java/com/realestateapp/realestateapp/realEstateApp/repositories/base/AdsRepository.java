package com.realestateapp.realestateapp.realEstateApp.repositories.base;

import com.realestateapp.realestateapp.realEstateApp.models.Ads;

import java.util.List;

public interface AdsRepository {
    List<Ads> findAll();
    List<Ads> findLatest5();

    Ads findById(Long id);
    Ads create(Ads ads);
    Ads edit(Ads ads);
    void deleteById(Long id);
}
