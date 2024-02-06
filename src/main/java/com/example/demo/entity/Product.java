package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product implements Comparable<Product> {

    public static Comparator<Product> NameComparator = Comparator.comparing(Product::getName);
    public static Comparator<Product> PriceComparator = new Comparator<Product>() {
        @Override
        public int compare(Product productOne, Product productTwo) {
            return productOne.getPrice().compareTo(productTwo.getPrice());
        }
    };

    public static Comparator<Product> IdComparator = new Comparator<Product>() {
        @Override
        public int compare(Product productOne, Product productTwo) {
            return (int) (productOne.id - productTwo.id);
        }
    };

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

    @Override
    public int compareTo(Product product) {
        return (int) (this.id - product.id);
    }
}
