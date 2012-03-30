package com.gordondickens.javaseven.paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class RemovingRedundanciesExample {
    private static final Logger logger = LoggerFactory.getLogger(RemovingRedundanciesExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/../music/Space Machine A.mp3");
        logger.debug("Absolute path: " + path.toAbsolutePath());
        logger.debug("URI: " + path.toUri());
        logger.debug("Normalized Path: " + path.normalize());
        logger.debug("Normalized URI: " + path.normalize().toUri());

        path = Paths.get("/home/./music/ Robot Brain A.mp3");
        logger.debug("Absolute path: " + path.toAbsolutePath());
        logger.debug("URI: " + path.toUri());
        logger.debug("Normalized Path: " + path.normalize());
        logger.debug("Normalized URI: " + path.normalize().toUri());

        //There's More: No Such File Exception Example
//        try {
//            Path path = Paths.get("/home/docs/../music/NonExistentFile.mp3");
//            logger.debug("Absolute path: " + path.toAbsolutePath());
//            logger.debug("Real path: " + path.toRealPath());
//            
//            } catch (IOException ex) {
//            logger.debug("The file does not exist!");
//        }

    }
}
