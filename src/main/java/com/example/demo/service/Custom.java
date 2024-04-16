package com.example.demo.service;

public interface Custom {

    default void test() {
        System.out.println("xyz");
    }
}
