package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ContentTypeExample {
    private static final Logger logger = LoggerFactory.getLogger(ContentTypeExample.class);

    public static void main(String[] args) throws Exception {
        displayContentType("/home/docs/users.txt");
        displayContentType("/home/docs/Chapter 2.doc");
        displayContentType("/home/docs/java.exe");
    }

    static void displayContentType(String pathText) throws Exception {
        Path path = Paths.get(pathText);
        String type = Files.probeContentType(path);
        logger.debug(type);
    }

}
