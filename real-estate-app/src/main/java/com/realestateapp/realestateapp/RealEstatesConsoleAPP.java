package com.realestateapp.realestateapp;

import com.realestateapp.realestateapp.models.*;
import javafx.geometry.Pos;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.TypedQuery;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;

class RealEstatesConsoleAPP{
    static SessionFactory factory;
 static {
         factory = new Configuration()
                 .configure("hibernate.cfg.xml")
                 .addAnnotatedClass(Post.class)
                 .addAnnotatedClass(User.class)
                 .addAnnotatedClass(Estate.class)
                 .addAnnotatedClass(Address.class)
                 .addAnnotatedClass(Material.class)
                 .buildSessionFactory();

 }

    public static void main(String[] args) {
        Session session = factory.openSession();
        session.beginTransaction();
        User existing = session.get(User.class, Long.parseLong("6"));
//        existing.getUserAds().forEach(System.out::println);
//        User newUser = new User("User166", "password",
//                "emaildasdasd", "firstName",
//                "lastName ");
//        System.out.println("USER CREATED");
//
//        System.out.println("ADD1 CREATED");
//        Post newPost2;
//        System.out.println("ADD2 CREATED");
//        Post newPost;
//        TypedQuery<User> q;
//        User existingUser = null;
//        try {
//            q = session.createQuery("FROM User AS o WHERE username = :name OR email = :email", User.class);
//            q.setParameter("name", newUser.getUsername());
//            q.setParameter("name", newUser.getEmail());
//            existingUser = q.getSingleResult();
//            newPost = new Post("Title2", "Desc2", existingUser);
//            newPost2= new Post("title2", "Description2", existingUser);
//            session.save(newPost);
//            session.save(newPost2);
//            System.out.println("Users Posts");
//            existingUser.getUserAds().stream().forEach(System.out::println);
//        }catch (Exception e){
//            newPost = new Post("Title2", "Desc2", newUser);
//            newPost2= new Post("title2", "Description2", newUser);
//            session.save(newUser);
//            session.save(newPost);
//            session.save(newPost2);
//            System.out.println("Users posts");
//            newUser.getUserAds().stream().forEach(System.out::println);
//        }

        session.getTransaction().commit();
        session.close();
    }
 }
