package com.example.demo.service;

import java.util.*;

public class PracticeCollections {

    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.add("One");
        arrayList.add("Two"); // order is maintained
        arrayList.add("Two"); // can store duplicates
        arrayList.add(null); // can store null
        System.out.println(arrayList);
        System.out.println("Random access(read) is fast: Insert and Deletion is slow");

        List<String> linkedList = new LinkedList<>();
        linkedList.add("One");
        linkedList.add("Two"); // order is maintained
        linkedList.add("Two"); // can store duplicates
        linkedList.add(null); // can store null
        System.out.println(linkedList);
        System.out.println("Random access(read) is slow: Insert and Deletion is fast");

        Set<String> hashSet = new HashSet<>();
        hashSet.add("One");
        hashSet.add("Two"); // no duplicates
        hashSet.add("Three"); // order is not maintained
        hashSet.add(null); // can insert null value
        System.out.println(hashSet);
        System.out.println("People say this is slower compared to arrayList,depends on the operations like contains, sort etc");

        Set<String> treeSet = new TreeSet<>();
        treeSet.add("One");
        treeSet.add("Two");
        treeSet.add("Three"); // order is maintained
//        treeSet.add(null); // can not insert null value
        System.out.println(treeSet);
        System.out.println("People say this is slower compared to arrayList,depends on the operations like contains, sort etc");

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "One"); // order is not maintained
        hashMap.put("2", "Two");// no duplicate keys
        hashMap.put(null, null);// can contain null key and null value
        System.out.println(hashMap);
        System.out.println("Faster, has random access");

        Map<String, String> treeMap = new TreeMap<>();
        treeMap.put("1", "One");
        treeMap.put("2", "Two"); // order is maintained
        treeMap.put("3", null); // no null key allowed, value can be null
        System.out.println(treeMap);
        System.out.println("Faster, has random access");

        System.out.println("""
                =======================================================================================
                ArrayList:  Order is maintained, can store null values, can store duplicates and faster
                LinkedList: Order is maintained, can store null values, can store duplicates and slower
                HashSet: Order is not maintained, can store null value(1), no duplicates and slower
                TreeSet: Order is maintained, NO NULLS, no duplicates and slower
                HashMap: Order is not maintained, can story null key (1), multiple null values, no duplicate keys and faster
                TreeMap: Order is maintained, NO NULL keys, can have null values, no duplicate keys and faster
                Vector is same ArrayList but with Thread Safety
                """);
    }
}
