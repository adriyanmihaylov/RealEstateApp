package com.realestateapp.realestateapp.realEstateApp.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import com.realestateapp.realestateapp.realEstateApp.models.Ads;
import com.realestateapp.realestateapp.realEstateApp.models.User;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public SessionFactory createSessionFactory() {
        System.out.println("SessionFactory was created.");

        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Ads.class)
                .addAnnotatedClass(User.class)
                .buildSessionFactory();
    }
}