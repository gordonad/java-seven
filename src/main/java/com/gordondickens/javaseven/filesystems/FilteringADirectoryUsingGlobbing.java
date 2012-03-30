package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;

public class FilteringADirectoryUsingGlobbing {
    private static final Logger logger = LoggerFactory.getLogger(FilteringADirectoryUsingGlobbing.class);

    public static void main(String[] args) {
        Path directory = Paths.get("/Program Files/Java/jdk1.7.0/bin");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, "java*.exe")) {
            for (Path file : directoryStream) {
                logger.debug(file.getFileName().toString());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }

        // Using the PathMatcher interface to filter a directory
//        Path directory = Paths.get("/Program Files/Java/jdk1.7.0/bin");
//        PathMatcher  pathMatcher = FileSystems.getDefault().getPathMatcher("glob:java?.exe");
//        try (DirectoryStream<Path> directoryStream = 
//                Files.newDirectoryStream(directory,"java*.exe")) {
//            for (Path file : directoryStream) {
//                if(pathMatcher.matches(file.getFileName())) {
//                    logger.debug(file.getFileName());
//                }
//            }
//        } catch (IOException | DirectoryIteratorException ex) {
//            ex.printStackTrace();
//        }

    }
}
