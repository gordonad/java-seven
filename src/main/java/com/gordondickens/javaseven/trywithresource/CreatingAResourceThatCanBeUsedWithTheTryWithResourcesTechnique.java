package com.gordondickens.javaseven.trywithresource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreatingAResourceThatCanBeUsedWithTheTryWithResourcesTechnique {
    private static final Logger logger = LoggerFactory.getLogger(CreatingAResourceThatCanBeUsedWithTheTryWithResourcesTechnique.class);

    public static void main(String[] args) {
        try (FirstAutoCloseableResource resource1 = new FirstAutoCloseableResource();
             SecondAutoCloseableResource resource2 = new SecondAutoCloseableResource()) {
            resource1.manipulateResource();
            resource2.manipulateResource();
        } catch (Exception e) {
            e.printStackTrace();
            for (Throwable throwable : e.getSuppressed()) {
                logger.error("error", throwable);
            }
        }

    }
}
