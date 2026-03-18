package com.klu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.klu.entity.Product;
import com.klu.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository repo;

    public Product save(Product p) {
        return repo.save(p);
    }

    public List<Product> getCategory(String category) {
        return repo.findByCategory(category);
    }

    public List<Product> getPriceRange(double min,double max) {
        return repo.findByPriceBetween(min, max);
    }

    public List<Product> getSorted() {
        return repo.sortByPrice();
    }

    public List<Product> getExpensive(double price) {
        return repo.findExpensive(price);
    }
}