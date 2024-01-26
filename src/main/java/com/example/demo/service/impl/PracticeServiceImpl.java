package com.example.demo.service.impl;

import com.example.demo.aop.LogMethodExecution;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PracticeServiceImpl implements ProductService {

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
            return productRepository.findAll();
        } catch (Exception e) {
            throw new RuntimeException("Exception occurred while retrieving product data: " + e.getMessage());
        }
    }
}
