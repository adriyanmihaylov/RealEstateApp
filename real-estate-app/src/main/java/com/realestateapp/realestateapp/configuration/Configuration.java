package com.realestateapp.realestateapp.configuration;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.realestateapp.realestateapp.models.*;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public SessionFactory createSessionFactory() {
        System.out.println("SessionFactory was created.");

        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Post.class)
                .addAnnotatedClass(Estate.class)
                .addAnnotatedClass(Address.class)
                .addAnnotatedClass(Material.class)
                .addAnnotatedClass(Type.class)
                .buildSessionFactory();
    }

    @Bean
    public Module datatypeHibernateModule() {
        return new Hibernate4Module();
    }
}