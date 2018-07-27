package com.realestateapp.realestateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import realEstateApp.models.*;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;

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
                .addAnnotatedClass(Types.class)
                .buildSessionFactory();
    }

    public static void main(String[] args) {
       Session session =  factory.openSession();
       session.beginTransaction();
//
//        User newUser = new User("jany.drenchev@gmail.com", "Yani",
//               "Drencgev", "passs");
//        Ads newAds = new Ads("Title1", "Description","Autor");
        Materials newMaterial = new Materials("Mainata mu");
        session.save(newMaterial);
        Types type = new Types("Kyshta");
        session.save(type);
        Addresses addresse = new Addresses("Orlandovci");
        session.save(addresse);
        Estates newEstate = new Estates(addresse,newMaterial,
                15000, 3, 5,"KurKapan", type);
       session.save(newEstate);


//
//        List <Types> estates = session.createQuery("FROM Types" ).list();
//        estates.forEach(System.out::println);
        session.getTransaction().commit();
        session.close();
    }
}
