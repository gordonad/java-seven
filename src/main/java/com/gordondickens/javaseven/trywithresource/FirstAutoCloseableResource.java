package com.gordondickens.javaseven.trywithresource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FirstAutoCloseableResource implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(FirstAutoCloseableResource.class);

    @Override
    public void close() throws Exception {
        // Close the resource as appropriate
        logger.debug("FirstAutoCloseableResource close method executed");
        throw new UnsupportedOperationException(
                "A problem has occurred in FirstAutoCloseableResource");
    }

    public void manipulateResource() {
        // Perform some resource specific operation
        logger.debug("FirstAutoCloseableResource manipulateResource method executed");
    }
}
