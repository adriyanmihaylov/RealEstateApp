package com.realestateapp.realestateapp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import realEstateApp.models.*;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        Session session = factory.openSession();
        session.beginTransaction();
//

//        Ads newAds = new Ads("Title1", "Description","Autor");
//        Materials newMaterial = new Materials("Mainata mu");
//        session.save(newMaterial);
//        Types type = new Types("Kyshta");
//        session.save(type);
//        Addresses addresse = new Addresses("Orlandovci");
//        session.save(addresse);
//        Estates newEstate = new Estates(addresse,newMaterial,
//                15000, 3, 5,"KurKapan", type);
//       session.save(newEstate);
//        USER ADDING
//        Set<Ads> ads = new HashSet<>();
//        Ads newAdd = new Ads("Title2", "Description1");
//        User newUser = new User("jany.drenchev@gmail.com", "Yani",
//                "Drencgev", "passs", newAdd);
//
//        session.save(newAdd);
//        session.save(newUser);

//
//        List <User> users = session.createQuery("FROM User" ).list();
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        users.forEach(System.out::println);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        users.forEach(x -> x.getUserAds().forEach(System.out::println));
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
//        session.getTransaction().commit();
//        session.close();
//    }
    }
}
