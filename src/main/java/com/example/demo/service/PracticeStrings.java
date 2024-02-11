package com.example.demo.service;

public class PracticeStrings {

    public static String string = "String is Immutable, Thread Safe, not synchronized";
    public static StringBuffer stringBuffer = new StringBuffer("StringBuffer is Mutable, Thread Safe, synchronized, slower");
    public static StringBuilder stringBuilder = new StringBuilder("StringBuilder is Mutable, Not Thread Safe, Not synchronized, faster");
}
