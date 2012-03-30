package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeViewExample {
    private static final Logger logger = LoggerFactory.getLogger(DosFileAttributeView.class);

    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("/home/docs/users.txt");
        try {
            DosFileAttributeView view = Files.getFileAttributeView(path, DosFileAttributeView.class);
            DosFileAttributes attributes = view.readAttributes();

            logger.debug("isArchive: " + attributes.isArchive());
            logger.debug("isHidden: " + attributes.isHidden());
            logger.debug("isReadOnly: " + attributes.isReadOnly());
            logger.debug("isSystem: " + attributes.isSystem());

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
