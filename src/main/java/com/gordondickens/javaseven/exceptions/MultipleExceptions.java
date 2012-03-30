package com.gordondickens.javaseven.exceptions;

import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultipleExceptions {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(MultipleExceptions.class);

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number < 0) {
                throw new InvalidParameter();
            }
            logger.debug("The number is: " + number);
        } catch (InputMismatchException | InvalidParameter e) {
            logger.debug("Invalid input, try again");
        }
    }
}
