package com.realestateapp.realestateapp.configuration;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerHelper {

        private static EntityManagerFactory factory;

        static {
            try {
              factory = Persistence.createEntityManagerFactory("User");
            } catch(ExceptionInInitializerError e) {
                throw e;
            }
        }

        public static EntityManagerFactory getFactory() {
            return factory;
        }

    }

