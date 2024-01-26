package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    void persistData() throws Exception;

    List<Product> getProductInformation(String name);
}
