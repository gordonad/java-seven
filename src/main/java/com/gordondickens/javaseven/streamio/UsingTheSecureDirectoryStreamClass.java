package com.gordondickens.javaseven.streamio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.PosixFileAttributeView;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;

public class UsingTheSecureDirectoryStreamClass {
    private static final Logger logger = LoggerFactory.getLogger(UsingTheSecureDirectoryStreamClass.class);

    public static void main(String args[]) throws IOException {
        Path path = Paths.get("home/docs");
        SecureDirectoryStream<Path> sds = (SecureDirectoryStream) Files.newDirectoryStream(path);
        PosixFileAttributeView view = sds.getFileAttributeView(PosixFileAttributeView.class);
        PosixFileAttributes attributes = view.readAttributes();
        Set<PosixFilePermission> permissions = attributes.permissions();
        String message = "";

        for (PosixFilePermission permission : permissions) {
            message += (permission.toString() + " ");
        }
        logger.debug(message);
    }
}
