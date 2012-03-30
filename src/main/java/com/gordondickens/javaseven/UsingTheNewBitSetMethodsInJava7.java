package com.gordondickens.javaseven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.BitSet;

public class UsingTheNewBitSetMethodsInJava7 {
    private static final Logger logger = LoggerFactory.getLogger(UsingTheNewBitSetMethodsInJava7.class);

    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        long[] array = {1, 21, 3};
        bitSet = BitSet.valueOf(array);
        logger.debug(bitSet.toString());

        long[] tmp = bitSet.toLongArray();
        for (long number : tmp) {
            logger.debug(Long.toString(number));
        }

        // There's more
        logger.debug(Integer.toString(bitSet.previousSetBit(1)));
        logger.debug(Integer.toString(bitSet.previousClearBit(66)));

    }
}
