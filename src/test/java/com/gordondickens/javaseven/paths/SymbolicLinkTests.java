package com.gordondickens.javaseven.paths;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SymbolicLinkTests {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(SymbolicLinkTests.class);

    @Ignore
    @Test
    public void testMe() {
        Path path1 = null;
        Path path2 = null;

        path1 = Paths.get("/home/docs/users.txt");
        path2 = Paths.get("/home/music/users.txt");

        logger.debug(Boolean.toString(Files.isSymbolicLink(path1)));
        logger.debug(Boolean.toString(Files.isSymbolicLink(path2)));

        try {
            Path path = Paths.get(new URI("/home/./music/users.txt"));
            logger.debug("Normalized: " + path.normalize());
            logger.debug("Absolute path: " + path.toAbsolutePath());
            logger.debug("URI: " + path.toUri());
            logger.debug("toRealPath (Do not follow links): " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
            logger.debug("toRealPath: " + path.toRealPath());


            Path firstPath = Paths.get("/home/music/users.txt");
            Path secondPath = Paths.get("/docs/status.txt");
            logger.debug("From firstPath to secondPath: " + firstPath.relativize(secondPath));
            logger.debug("From secondPath to firstPath: " + secondPath.relativize(firstPath));
            logger.debug("exists (Do not follow links): " + Files.exists(firstPath, LinkOption.NOFOLLOW_LINKS));
            logger.debug("exists: " + Files.exists(firstPath));
            logger.debug("notExists (Do not follow links): " + Files.notExists(firstPath, LinkOption.NOFOLLOW_LINKS));
            logger.debug("notExists: " + Files.notExists(firstPath));

        } catch (URISyntaxException | IOException ex) {
            Logger.getLogger(SymbolicLinkTests.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidPathException ex) {
            logger.debug("Bad path: [" + ex.getInput() + "] at position " + ex.getIndex());
        }
    }
}
