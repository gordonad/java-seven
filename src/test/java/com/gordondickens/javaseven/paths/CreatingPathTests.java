package com.gordondickens.javaseven.paths;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CreatingPathTests {
    private static final Logger logger = LoggerFactory.getLogger(CreatingPathTests.class);

    @Test
    public void testMe() {
        Path firstPath;
        Path secondPath;
        firstPath = Paths.get("music/Future Setting A.mp3");
        secondPath = Paths.get("docs");

        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));

        firstPath = Paths.get("music/Future Setting A.mp3");
        secondPath = Paths.get("music");
        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));

        firstPath = Paths.get("music/Future Setting A.mp3");
        secondPath = Paths.get("docs/users.txt");
        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));

//        How It Works example
//        firstPath = Paths.get("music/Future Setting A.mp3");
//        secondPath = Paths.get("docs/tmp/users.txt");
//        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));

        //There's More: Paths are equal
//        firstPath = Paths.get("music/Future Setting A.mp3");
//        secondPath = Paths.get("music/Future Setting A.mp3");
//        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));
//        logger.debug();

        //There's More: One path contains a root
//        firstPath = Paths.get("/music/Future Setting A.mp3");
//        secondPath = Paths.get("docs/users.txt");
//        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));
//        logger.debug();

        //There's More: Both paths contain a root
//        firstPath = Paths.get("/music/Future Setting A.mp3");
//        secondPath = Paths.get("/docs/users.txt");
//        logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
//        logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));
//        logger.debug();


    }
}
