package realEstateApp.services;

import realEstateApp.models.Ads;
import realEstateApp.repositories.base.AdsRepository;
import realEstateApp.services.base.AdsService;

import java.util.List;

public class AdsServiceImpl implements AdsService {

    private AdsRepository adsRepository;

    public AdsServiceImpl(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    @Override
    public List<Ads> findAll() {
        return adsRepository.findAll();
    }

    @Override
    public List<Ads> findLatest5() {
        return adsRepository.findLatest5();
    }

    @Override
    public Ads findById(Long id) {
        return adsRepository.findById(id);
    }

    @Override
    public Ads create(Ads ad) {
        return adsRepository.create(ad);
    }

    @Override
    public Ads edit(Ads ad) {
        return adsRepository.edit(ad);
    }

    @Override
    public void deleteById(Long id) {
        adsRepository.deleteById(id);
    }
}
