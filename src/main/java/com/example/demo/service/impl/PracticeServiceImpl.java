package com.example.demo.service.impl;

import com.example.demo.aop.LogMethodExecution;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.Custom;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PracticeServiceImpl implements ProductService, Custom {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void persistData() {
        List<Product> products = new ArrayList<>();
        products.add(Product.builder().name("Wall Art").description("wall Art").price("$10").availableStockCount("10L").build());
        products.add(Product.builder().name("TV Art").description("TV Art").price("$10").availableStockCount("10L").build());
        products.add(Product.builder().name("Sofa Art").description("Sofa Art").price("$10").availableStockCount("10L").build());
        products.add(Product.builder().name("Kitchen Art").description("Kitchen Art").price("$10").availableStockCount("10L").build());
        productRepository.saveAll(products);
    }

    @Override
    @Cacheable("products")
    @LogMethodExecution
    public List<Product> getProductInformation(String name) {
        try {
            persistData();
            List<Product> products = productRepository.findAll();

            products.sort(Product.NameComparator); // manual sort based on field using comparator
            products.sort(Product.PriceComparator); // manual sort based on field using comparator
            Collections.sort(products); // Default sort using comparable

            //products.sort(new Product()); if we want to use just comparator alone with default sort
            return products;
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while retrieving product data: " + e.getMessage());
        }
    }

    @Override
    public void test() {
        ProductService.super.test();
    }
}
