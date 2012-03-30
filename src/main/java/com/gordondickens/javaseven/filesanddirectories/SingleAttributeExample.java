package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class SingleAttributeExample {
    private static final Logger logger = LoggerFactory.getLogger(SingleAttributeExample.class);

    public static void main(String[] args) {
        try {
            Path path = FileSystems.getDefault().getPath("/home/docs/users.txt");
            logger.debug(Files.getAttribute(path, "size").toString());
        } catch (IOException ex) {
            logger.debug("IOException");
        }
    }
}
