package com.gordondickens.javaseven.paths;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConvertingPathsTests {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConvertingPathsTests.class);

    @Ignore
    @Test(expected = NoSuchFileException.class)
    public void testMe() {
        try {
//            String filePath = getClass().getResource("someData.txt").getFile();
//            logger.debug("***** file Path returned '{}' *****", filePath);
            Path path = Paths.get("/code/java-seven/src/test/resources/someData.txt");

            logger.debug("URI path: " + path.toUri());
            logger.debug("Absolute path: " + path.toAbsolutePath());
            logger.debug("Real path: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (IOException ex) {
            logger.debug("", ex);
        }
    }

    @Ignore
    @Test(expected = NoSuchFileException.class)
    public void testMeToo() {
        try {
            Path path = Paths.get("/code/java-seven/src/test/resources/invalidFileName.txt");
            if (path.toFile().exists()) {
                logger.debug("Real path: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
            } else {
                logger.debug("The file {} does not exist", path.toString());
            }
        } catch (IOException ex) {
            logger.debug("", ex);
        }
    }
}