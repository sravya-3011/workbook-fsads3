package com.klu.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    // Static block to initialize SessionFactory
    static {
        try {
            // Load configuration and build session factory
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml") // loads config file
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("SessionFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Method to get SessionFactory
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    // Method to shutdown SessionFactory
    public static void shutdown() {
        getSessionFactory().close();
    }
}