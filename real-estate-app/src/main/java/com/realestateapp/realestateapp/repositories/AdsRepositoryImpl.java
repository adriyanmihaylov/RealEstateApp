package com.realestateapp.realestateapp.repositories;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.realestateapp.realestateapp.models.Ads;
import com.realestateapp.realestateapp.repositories.base.AdsRepository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class AdsRepositoryImpl implements AdsRepository {
    private SessionFactory factory;

    public AdsRepositoryImpl(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Ads> findAll() {
        List<Ads> allAds = new ArrayList<>();
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            allAds = session.createQuery("from Ads").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return allAds;
    }

    @Override
    public List<Ads> findLatest5() {
        return null;
    }

    @Override
    public Ads findById(Long id) {
        Ads ad = null;
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            ad = session.get(Ads.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ad;
    }

    @Override
    public Ads create(Ads newAd) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(newAd);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newAd;
    }

    @Override
    public Ads edit(Ads ad) {

        return ad;
    }

    @Override
    public String deleteById(Long id) {
        Ads ad = findById(id);
        if (ad != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(ad);
                session.getTransaction().commit();
                return "The add was successfully deleted!";
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "There is no such ad!";
    }
}