package com.gordondickens.javaseven.paths;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class UnderstandingTests {
    private static final Logger logger = LoggerFactory.getLogger(UnderstandingTests.class);

    @Test
    public void testMe() {
        Path path = FileSystems.getDefault().getPath("/home/docs/status.txt");

        logger.debug("toString: %s\n", path.toString());
        logger.debug("getFileName: %s\n", path.getFileName());
        logger.debug("getRoot: %s\n", path.getRoot());
        logger.debug("getNameCount: %d\n", path.getNameCount());
        for (int index = 0; index < path.getNameCount(); index++) {
            logger.debug("getName(%d): %s\n", index, path.getName(index));
        }


        logger.debug("subpath(0,2): %s\n", path.subpath(0, 2));
        logger.debug("getParent: %s\n", path.getParent());
        logger.debug(Boolean.toString(path.isAbsolute()));

    }

    //There's More: Using the get method
//        path = Paths.get("/home", "docs", "users.txt");
//        logger.debug("Absolute path: " + path.toAbsolutePath());
//        path = Paths.get("home", "docs", "users.txt");
//        logger.debug("Absolute path: " + path.toAbsolutePath());
//        try {
//            path = Paths.get("/home\0", "docs", "users.txt");
//            logger.debug("Absolute path: " + path.toAbsolutePath());
//        } catch (InvalidPathException ex) {
//            logger.debug("Bad path: [" + ex.getInput() + "] at position " + ex.getIndex());
//        }


//}
}
