package com.gordondickens.javaseven.exceptions;

import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CatchingMultipleExceptionTypesToImproveTypeHandling {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(CatchingMultipleExceptionTypesToImproveTypeHandling.class);

    public static void main(String[] args) {
        System.out.print("Enter a number: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number < 0) {
                throw new InvalidParameter();
            }
            logger.debug("The number is: " + number);
            if (number > 10) {
                throw new AssertionError("Number was too big", new Throwable("Throwable assertion message"));
            }
        } catch (InputMismatchException | InvalidParameter e) {
            logger.debug("Invalid input, try again");
            e.addSuppressed(new Throwable());
            logger.debug("Invalid input, try again");
        } catch (final Exception e) {
            logger.debug("Invalid input, try again");
            logger.debug("Invalid input, try again");
        }
    }
}
