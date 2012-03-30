package com.gordondickens.javaseven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UnderscoresInLiterals {
    private static final Logger logger = LoggerFactory.getLogger(UnderscoresInLiterals.class);

    public static void main(String[] args) {
        long debitCard = 1234_5678_9876_5432L;
        logger.debug("The card number is: " + debitCard);
        logger.debug("The formatted card number is: {}", printFormatted(debitCard));

        float minAmount = 5_000F;
        float currentAmount = 5_250F;
        float withdrawalAmount = 500F;

        if ((currentAmount - withdrawalAmount) < minAmount) {
            logger.debug("Minimum amount limit exceeded " + minAmount);
        }

        //There's More: Using underscores with binary literals
//        byte initializationSequence = (byte) 0b01_110_010;
//        byte inputValue = (byte) 0b101_11011;
//
//        byte result = (byte) (inputValue & (byte) 0b000_11111);
//        logger.debug("initializationSequence: " +
//                Integer.toBinaryString(initializationSequence));
//        logger.debug("result: " + Integer.toBinaryString(result));
    }

    private static String printFormatted(long cardNumber) {
        String formattedNumber = Long.toString(cardNumber);
        String result = "";
        for (int i = 0; i < formattedNumber.length(); i++) {
            if (i % 4 == 0) {
                result += " ";
            }
            result += formattedNumber.charAt(i);
        }
        return result;
    }
}
