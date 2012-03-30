package com.gordondickens.javaseven;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryWithResourcesTests {
    private static final Logger logger = LoggerFactory.getLogger(TryWithResourcesTests.class);

    @Test
    public void tryWithResources() {
        //Note the try block - contains resources that need to be handled
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

    //Class implementing Java 7 AutoCloseable
    class FirstAutoCloseableResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            // Close the resource as appropriate
            logger.debug("FirstAutoCloseableResource - Close method executed");
        }

        public void manipulateResource() {
            // Perform some resource specific operation
            logger.debug("FirstAutoCloseableResource - ManipulateResource method executed");
        }
    }

    //Class implementing Java 7 AutoCloseable
    class SecondAutoCloseableResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            // Close the resource as appropriate
            logger.debug("SecondAutoCloseableResource - Close method executed");
        }

        public void manipulateResource() {
            // Perform some resource specific operation
            logger.debug("SecondAutoCloseableResource - ManipulateResource method executed");
        }
    }
}
