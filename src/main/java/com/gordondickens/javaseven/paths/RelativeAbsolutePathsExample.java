package com.gordondickens.javaseven.paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;

public class RelativeAbsolutePathsExample {
    private static final Logger logger = LoggerFactory.getLogger(RelativeAbsolutePathsExample.class);

    public static void main(String[] args) {
        String separator;
        separator = FileSystems.getDefault().getSeparator();
        logger.debug("The separator is " + separator);
        try {
            Path path = Paths.get(new URI("file:////home/docs/users.txt"));
            logger.debug("subpath: " + path.subpath(0, 3));
            path = Paths.get("/home", "docs", "users.txt");
            logger.debug("Absolute path: " + path.toAbsolutePath());
            logger.debug("URI: " + path.toUri());

            //There's More: Bogus File example
//            Path path = Paths.get(new URI("file:////home/docs/bogusfile.txt"));
//		 logger.debug("File exists: " + Files.exists(path));
//            path = Paths.get("/home", "docs", "bogusfile.txt");
            logger.debug("File exists: " + Files.exists(path));
//            logger.debug("subpath: " + path.subpath(0, 3));
//            logger.debug("Absolute path: " + path.toAbsolutePath());
//            logger.debug("URI: " + path.toUri());

        } catch (URISyntaxException ex) {
            logger.debug("Bad URI");
        } catch (InvalidPathException ex) {
            logger.debug("Bad path: [" + ex.getInput() + "] at position " + ex.getIndex());
        }
    }
}
