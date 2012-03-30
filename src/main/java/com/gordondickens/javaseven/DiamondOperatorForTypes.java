package com.gordondickens.javaseven;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DiamondOperatorForTypes {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        List<Map<String, List<String>>> stringList = new ArrayList<>();

        //There's More:Using <> when the type is not obvious
//        List arrayList = new ArrayList<>();
//        List<String> arrayList = new ArrayList<>();
//        arrayList.add("First");
//        arrayList.add("Second");

//        //There's More: Suppressing Unchecked Warnings
//        @SuppressWarnings("unchecked")
//        List<String> arrayList = new ArrayList();


//        //There's More: Understanding Erasure
//    private static void useRawType() {
//        List<String> arrayList = new ArrayList();
//        arrayList.add("First");
//        arrayList.add("Second");
//        logger.debug(arrayList.get(0));
//    }
//
//    private static void useExplicitType() {
//        List<String> arrayList = new ArrayList<String>();
//        arrayList.add("First");
//        arrayList.add("Second");
//        logger.debug(arrayList.get(0));
//    }
//
//    private static void useImplicitType() {
//        List<String> arrayList = new ArrayList<>();
//        arrayList.add("First");
//        arrayList.add("Second");
//        logger.debug(arrayList.get(0));
//    }
    }
}
