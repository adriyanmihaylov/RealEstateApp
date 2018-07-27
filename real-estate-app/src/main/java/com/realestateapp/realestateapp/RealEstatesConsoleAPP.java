package com.realestateapp.realestateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import realEstateApp.models.Ads;
import realEstateApp.models.User;

public class RealEstatesConsoleAPP {
    static SessionFactory factory;

    static {
        factory = new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Ads.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
       Session session =  factory.openSession();
       session.beginTransaction();
        Ads ads = new Ads();
//        session.save(newEmployee);
//        session.getTransaction().commit();
//        session.close();
    }
}
