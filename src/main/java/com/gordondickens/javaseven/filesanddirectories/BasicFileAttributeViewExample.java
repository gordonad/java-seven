package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;

public class BasicFileAttributeViewExample {
    private static final Logger logger = LoggerFactory.getLogger(BasicFileAttributeViewExample.class);

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/home/docs/users.txt");
        try {
//            BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
            BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
            BasicFileAttributes attributes = view.readAttributes();

            logger.debug("Creation Time: " + attributes.creationTime());
            logger.debug("Last Accessed Time: " + attributes.lastAccessTime());
            logger.debug("Last Modified Time: " + attributes.lastModifiedTime());
            logger.debug("File Key: " + attributes.fileKey());
            logger.debug("Directory: " + attributes.isDirectory());
            logger.debug("Other Type of File: " + attributes.isOther());
            logger.debug("Regular File: " + attributes.isRegularFile());
            logger.debug("Symbolic File: " + attributes.isSymbolicLink());
            logger.debug("Size: " + attributes.size());
        } catch (IOException ex) {
            logger.debug("Attribute error");
        }
    }
}