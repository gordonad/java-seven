package com.gordondickens.javaseven.concurrency;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomExample {
    private static final Logger logger = LoggerFactory.getLogger(ThreadLocalRandomExample.class);

    public static void main(String[] args) {
        logger.debug("Five random integers");
        for (int i = 0; i < 5; i++) {
            logger.debug(Integer.toString(ThreadLocalRandom.current().nextInt()));
        }

        logger.debug("Random double number between 0.0 and 35.0");
        logger.debug(Double.toString(ThreadLocalRandom.current().nextDouble(35.0)));

        logger.debug("Five random Long numbers between 1234567 and 7654321");
        for (int i = 0; i < 5; i++) {
            logger.debug(
                    Long.toString(ThreadLocalRandom.current().nextLong(1234567L, 7654321L)));
        }
    }
}
