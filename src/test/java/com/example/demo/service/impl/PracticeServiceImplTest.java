package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class PracticeServiceImplTest {

    private List<Product> products;
    @MockBean
    private ProductRepository productRepository;
    @Autowired
    private PracticeServiceImpl practiceService;

    @BeforeEach
    void setUp() {
        products = new ArrayList<>();
        products.add(Product.builder().name("Wall Art").description("wall Art").price("$10").availableStockCount("10L").build());
        products.add(Product.builder().name("TV Art").description("TV Art").price("$10").availableStockCount("10L").build());
        products.add(Product.builder().name("Sofa Art").description("Sofa Art").price("$10").availableStockCount("10L").build());
        products.add(Product.builder().name("Kitchen Art").description("Kitchen Art").price("$10").availableStockCount("10L").build());
    }

    @Test
    void getProductInformation() {
        when(productRepository.saveAll(any())).thenReturn(products);
        when(productRepository.findAll()).thenReturn(products);
        List<Product> productInformation = practiceService.getProductInformation("");
        assertEquals(productInformation.size(), 4);
        verify(productRepository, times(1)).saveAll(any());
        verify(productRepository, times(1)).findAll();
    }
}