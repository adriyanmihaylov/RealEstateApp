package realEstateApp.repositories.base;

import realEstateApp.models.Ads;

import java.util.List;

public interface AdsRepository {
    List<Ads> findAll();
    List<Ads> findLatest5();

    Ads findById(Long id);
    Ads create(Ads ads);
    Ads edit(Ads ads);
    void deleteById(Long id);
}
