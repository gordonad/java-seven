package com.gordondickens.javaseven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

public class HandlingNullReferences {
    private static final Logger logger = LoggerFactory.getLogger(HandlingNullReferences.class);

    public static void main(String[] args) {
        Item item1 = new Item("Eraser", 2200);
        Item item2 = new Item("Eraser", 2200);
        Item item3 = new Item("Pencil", 1100);
        Item item4 = null;

        logger.debug("item1 equals item1: " + item1.equals(item1));
        logger.debug("item1 equals item2: " + item1.equals(item2));
        logger.debug("item1 equals item3: " + item1.equals(item3));
        logger.debug("item1 equals item4: " + item1.equals(item4));

        item2.setName(null);
        logger.debug("item1 equals item2: " + item1.equals(item2));

        // Additional Objects class methods
//        item4 = null;
//        logger.debug("toString: " + Objects.toString(item4));
//        logger.debug("toString: " + Objects.toString(item4,"Item is null"));

        // Using empty iterators to avoid null pointer exceptions
//        ListIterator<String> list = returnEmptyListIterator();
//        while(list.hasNext()) {
//            String item = list.next();
//            logger.debug(item);
    }


    // Using empty iterators to avoid null pointer exceptions
    public static ListIterator<String> returnEmptyListIterator() {
        boolean someConditionMet = false;
        if (someConditionMet) {
            ArrayList<String> list = new ArrayList<>();
            // Add elements
            ListIterator<String> listIterator = list.listIterator();
            return listIterator;
        } else {
            return Collections.emptyListIterator();
        }
    }

}
