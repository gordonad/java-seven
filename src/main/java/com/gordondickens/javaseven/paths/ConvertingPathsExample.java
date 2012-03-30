package com.gordondickens.javaseven.paths;

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConvertingPathsExample {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConvertingPathsExample.class);

    public static void main(String[] args) {
        try {
            Path path;
            path = Paths.get("users.txt");

            //There's More
//            path = Paths.get("invalidFileName.txt");
//            if (path.toFile().exists()) {
//                logger.debug("Real path: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
//            } else {
//                logger.debug("The file does not exist");
//            }

            logger.debug("URI path: " + path.toUri());
            logger.debug("Absolute path: " + path.toAbsolutePath());
            logger.debug("Real path: " + path.toRealPath(LinkOption.NOFOLLOW_LINKS));
        } catch (IOException ex) {
            Logger.getLogger(ConvertingPathsExample.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
