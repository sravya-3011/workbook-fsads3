package com.klu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.klu.entity.Product;
import com.klu.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/add")
    public Product addProduct(@RequestBody Product p) {
        return service.save(p);
    }

    @GetMapping("/category/{category}")
    public List<Product> getCategory(@PathVariable String category) {
        return service.getCategory(category);
    }

    @GetMapping("/filter")
    public List<Product> getPriceRange(@RequestParam double min,
                                       @RequestParam double max) {
        return service.getPriceRange(min, max);
    }

    @GetMapping("/sorted")
    public List<Product> getSorted() {
        return service.getSorted();
    }

    @GetMapping("/expensive/{price}")
    public List<Product> getExpensive(@PathVariable double price) {
        return service.getExpensive(price);
    }
}