package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class POSIXExample {
    private static final Logger logger = LoggerFactory.getLogger(POSIXExample.class);

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("home/docs/users.txt");
        FileSystem fileSystem = path.getFileSystem();
        PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

        PosixFileAttributes attributes = view.readAttributes();
        logger.debug("Group: " + attributes.group());
        logger.debug("Owner: " + attributes.owner().getName());

        Set<PosixFilePermission> permissions = attributes.permissions();
        String result = "";
        for (PosixFilePermission permission : permissions) {
            result += (permission.name() + " ");
        }
        logger.debug(result);

    }
}