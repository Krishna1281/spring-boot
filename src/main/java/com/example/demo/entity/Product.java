package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @GeneratedValue
    @Column
    @jakarta.persistence.Id
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String price;

    @Column
    private String availableStockCount;
}
