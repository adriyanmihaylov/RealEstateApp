package com.realestateapp.realestateapp.configuration;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import com.realestateapp.realestateapp.models.Post;
import com.realestateapp.realestateapp.models.User;
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public SessionFactory createSessionFactory() {
        System.out.println("SessionFactory was created.");

        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Post.class)
                .buildSessionFactory();
    }
}