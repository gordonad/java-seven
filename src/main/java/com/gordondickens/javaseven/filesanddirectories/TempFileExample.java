package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;


public class TempFileExample {
    private static final Logger logger = LoggerFactory.getLogger(TempFileExample.class);

    public static void main(String[] args) {

        Path rootDirectory = FileSystems.getDefault().getPath("/home/docs");

        try {
            Path tempDirectory = Files.createTempDirectory(rootDirectory, "");
            logger.debug("Temporary directory created successfully!");
            String dirPath = tempDirectory.toString();
            logger.debug(dirPath);
            Path tempFile = Files.createTempFile(tempDirectory, "", "");
            logger.debug("Temporary file created successfully!");
            String filePath = tempFile.toString();
            logger.debug(filePath);
        } catch (IOException e) {
            logger.debug("IO Exception.");
        }
    }
}
