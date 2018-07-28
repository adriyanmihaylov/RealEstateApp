package com.realestateapp.realestateapp.realEstateApp.repositories;

import org.springframework.stereotype.Repository;
import com.realestateapp.realestateapp.realEstateApp.models.Ads;
import com.realestateapp.realestateapp.realEstateApp.repositories.base.AdsRepository;

import java.util.List;
@Repository
public class AdsRepositoryImpl implements AdsRepository {
    @Override
    public List<Ads> findAll() {
        return null;
    }

    @Override
    public List<Ads> findLatest5() {
        return null;
    }

    @Override
    public Ads findById(Long id) {
        return null;
    }

    @Override
    public Ads create(Ads ads) {
        return null;
    }

    @Override
    public Ads edit(Ads ads) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
