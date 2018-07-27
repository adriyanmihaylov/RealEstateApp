package com.realestateapp.realestateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import realEstateApp.models.*;

import java.lang.reflect.Type;
import java.util.HashSet;

public class RealEstatesConsoleAPP {
    static SessionFactory factory;

    static {
        factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Ads.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Materials.class)
                .addAnnotatedClass(Addresses.class)
                .addAnnotatedClass(Estates.class)
                .addAnnotatedClass(Type.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
       Session session =  factory.openSession();
       session.beginTransaction();

        User newUser = new User("jany.drenchev@gmail.com", "Yani",
               "Drencgev", "passs");
        Ads newAds = new Ads("Title1", "Description","Autor");
        Materials newMaterial = new Materials("Тухла");
        session.save(newUser);
        session.save(newAds);
        session.save(newMaterial);
        session.getTransaction().commit();
        session.close();
    }
}
