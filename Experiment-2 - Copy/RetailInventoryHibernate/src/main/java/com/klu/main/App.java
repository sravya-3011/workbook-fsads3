package com.klu.main;

import com.klu.dao.ProductDAO;
import com.klu.entity.Product;

public class App {

    public static void main(String[] args) {

        ProductDAO dao = new ProductDAO();

        // Insert Row 1
        Product p1 = new Product(
                "Laptop",
                "Gaming Laptop",
                75000,
                10
        );

        // Insert Row 2
        Product p2 = new Product(
                "Mobile",
                "Android Phone",
                25000,
                20
        );

        // Insert Row 3
        Product p3 = new Product(
                "Keyboard",
                "Mechanical Keyboard",
                3500,
                15
        );

        // Save to database
        dao.addProduct(p1);
        dao.addProduct(p2);
        dao.addProduct(p3);

        System.out.println("Rows inserted successfully!");
    }
}