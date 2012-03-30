package com.gordondickens.javaseven.trywithresource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecondAutoCloseableResource implements AutoCloseable {
    private static final Logger logger = LoggerFactory.getLogger(SecondAutoCloseableResource.class);

    @Override
    public void close() throws Exception {
        // Close the resource as appropriate 
        logger.debug("SecondAutoCloseableResource close method executed");
        throw new UnsupportedOperationException(
                "A problem has occurred in SecondAutoCloseableResource");
    }

    public void manipulateResource() {
        // Perform some resource specific operation
        logger.debug("SecondAutoCloseableResource manipulateResource method executed");
    }
}
