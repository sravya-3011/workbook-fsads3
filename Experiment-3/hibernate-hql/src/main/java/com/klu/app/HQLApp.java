package com.klu.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.klu.model.Product;
import com.klu.util.HibernateUtil;

public class HQLApp {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        try {

            // ================= INSERT DATA =================
            session.save(new Product("Laptop", "Electronics", 60000, 10));
            session.save(new Product("Phone", "Electronics", 30000, 20));
            session.save(new Product("Shirt", "Clothing", 1500, 50));
            session.save(new Product("Shoes", "Footwear", 2500, 30));
            session.save(new Product("Watch", "Accessories", 5000, 15));
            session.save(new Product("Bag", "Accessories", 2000, 25));

            tx.commit();
            System.out.println("Data inserted successfully ✅");

            // ================= HQL QUERIES =================

            System.out.println("\n--- Price ASC ---");
            session.createQuery("FROM Product p ORDER BY p.price ASC", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

            System.out.println("\n--- Price DESC ---");
            session.createQuery("FROM Product p ORDER BY p.price DESC", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

            System.out.println("\n--- Quantity DESC ---");
            session.createQuery("FROM Product p ORDER BY p.quantity DESC", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName() + " " + p.getQuantity()));

            System.out.println("\n--- First 3 Products ---");
            session.createQuery("FROM Product", Product.class)
                    .setFirstResult(0)
                    .setMaxResults(3)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

            System.out.println("\n--- Next 3 Products ---");
            session.createQuery("FROM Product", Product.class)
                    .setFirstResult(3)
                    .setMaxResults(3)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

            Long total = session.createQuery(
                    "SELECT COUNT(p) FROM Product p", Long.class).uniqueResult();
            System.out.println("\nTotal Products: " + total);

            Long available = session.createQuery(
                    "SELECT COUNT(p) FROM Product p WHERE p.quantity > 0", Long.class)
                    .uniqueResult();
            System.out.println("Available Products: " + available);

            System.out.println("\n--- Count by Description ---");
            List<Object[]> groupList = session.createQuery(
                    "SELECT p.description, COUNT(p) FROM Product p GROUP BY p.description")
                    .list();

            for (Object[] row : groupList) {
                System.out.println(row[0] + " -> " + row[1]);
            }

            Object result = session.createQuery(
                    "SELECT MIN(p.price), MAX(p.price) FROM Product p")
                    .uniqueResult();

            Object[] minMax = (Object[]) result;

            System.out.println("\nMin Price: " + minMax[0]);
            System.out.println("Max Price: " + minMax[1]);

            System.out.println("\n--- Price between 2000 and 50000 ---");
            session.createQuery(
                    "FROM Product p WHERE p.price BETWEEN 2000 AND 50000", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

            System.out.println("\n--- Starts with S ---");
            session.createQuery("FROM Product p WHERE p.name LIKE 'S%'", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

            System.out.println("\n--- Ends with e ---");
            session.createQuery("FROM Product p WHERE p.name LIKE '%e'", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

            System.out.println("\n--- Contains 'at' ---");
            session.createQuery("FROM Product p WHERE p.name LIKE '%at%'", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

            System.out.println("\n--- Name length = 5 ---");
            session.createQuery("FROM Product p WHERE LENGTH(p.name)=5", Product.class)
                    .list()
                    .forEach(p -> System.out.println(p.getName()));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
            HibernateUtil.shutdown();
        }
    }
}