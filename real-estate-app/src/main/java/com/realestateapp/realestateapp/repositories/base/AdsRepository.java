package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Ads;

import java.util.List;

public interface AdsRepository {
    List<Ads> findAll();

    Ads findById(Long id);

    void create(Ads newAd);

    Ads edit(Ads ad);

    void deleteById(Long id) throws Exception;
}
