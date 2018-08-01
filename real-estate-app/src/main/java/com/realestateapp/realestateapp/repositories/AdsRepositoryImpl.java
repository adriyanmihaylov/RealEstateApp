package com.realestateapp.realestateapp.repositories;

import javassist.NotFoundException;
import org.apache.catalina.connector.Response;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.omg.CORBA.NO_RESOURCES;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.realestateapp.realestateapp.models.Ads;
import com.realestateapp.realestateapp.repositories.base.AdsRepository;

import javax.servlet.ServletOutputStream;
import javax.xml.ws.http.HTTPException;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static javax.servlet.http.HttpServletResponse.SC_NOT_FOUND;

@Repository
public class AdsRepositoryImpl implements AdsRepository {
    private static SessionFactory factory ;
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
    public void create(Ads newAd) {
        //TODO Validation
        try (Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(newAd);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
        System.out.println("Created Successfully");
    }

    @Override
    public void edit(Ads ad) {
        try (Session session = factory.openSession()) {
            session.beginTransaction();
//            Ads toBeUpdate = session.get(Ads.class,ad.getId());
            session.update(ad);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR");
        }
        System.out.println("Updated Successfully");

    }

    @Override
    public void deleteById(Long id) throws Exception {
        Ads ad = findById(id);
        if (ad != null) {
            try (Session session = factory.openSession()) {
                session.beginTransaction();
                session.delete(ad);
                session.getTransaction().commit();
                System.out.println( "The add was successfully deleted!");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println( "There is no such ad!");
        throw new Exception();
    }
}