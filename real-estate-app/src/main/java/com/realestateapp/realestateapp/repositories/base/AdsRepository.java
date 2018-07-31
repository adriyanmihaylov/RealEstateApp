package com.realestateapp.realestateapp.repositories.base;

import com.realestateapp.realestateapp.models.Ads;

import java.util.List;

public interface AdsRepository {
    List<Ads> findAll();

    List<Ads> findLatest5();

    Ads findById(Long id);

    Ads create(Ads newAd);

    Ads edit(Ads ad);

    String deleteById(Long id);
}
