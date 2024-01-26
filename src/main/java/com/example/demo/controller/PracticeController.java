package com.example.demo.controller;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "/v1")
@CrossOrigin
public class PracticeController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    private ResponseEntity<List<Product>> getProducts() {
        List<Product> response = new ArrayList<>();
        try {
            response = productService.getProductInformation("Krishna");
        } catch (Exception e) {
            return new ResponseEntity<>(response, HttpStatus.BAD_GATEWAY);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/insertData")
    private ResponseEntity<String> insertData() {
        try {
            productService.persistData();
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
