package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class DeleteDirectory extends SimpleFileVisitor<Path> {
    private static final Logger logger = LoggerFactory.getLogger(DeleteDirectory.class);

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes)
            throws IOException {
        logger.debug("Deleting " + file.getFileName());
        Files.delete(file);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path directory, IOException exception)
            throws IOException {
        if (exception == null) {
            logger.debug("Deleting " + directory.getFileName());
            Files.delete(directory);
            return FileVisitResult.CONTINUE;
        } else {
            throw exception;
        }
    }
}

