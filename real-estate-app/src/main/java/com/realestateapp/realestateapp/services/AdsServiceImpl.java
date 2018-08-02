package com.realestateapp.realestateapp.services;

import org.springframework.stereotype.Service;
import com.realestateapp.realestateapp.models.Ads;
import com.realestateapp.realestateapp.repositories.base.AdsRepository;
import com.realestateapp.realestateapp.services.base.AdsService;

import java.util.List;
@Service
public class AdsServiceImpl implements AdsService {

    private AdsRepository adsRepository;

    public AdsServiceImpl(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    @Override
    public List<Ads> findAll() {
        return adsRepository.findAll();
    }

    //TODO Find the latest five, not in the repository. Here is the logic
    @Override
    public List<Ads> findLatest5() {
        List<Ads> latestFive = adsRepository.findAll();
        return latestFive;
    }

    @Override
    public Ads findById(Long id) {
        return adsRepository.findById(id);
    }

    @Override
    public void create(Ads ad) {
        adsRepository.create(ad);
    }

    @Override
    public void edit(Ads ad) {
        adsRepository.edit(ad);
    }

    @Override
    public void deleteById(Long id) throws Exception {
        adsRepository.deleteById(id);
    }
}