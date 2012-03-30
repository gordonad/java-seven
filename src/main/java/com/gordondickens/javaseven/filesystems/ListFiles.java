package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

class ListFiles extends SimpleFileVisitor<Path> {
    private final int indentionAmount = 3;
    private int indentionLevel;
    private static final Logger logger = LoggerFactory.getLogger(SimpleFileVisitor.class);

    public ListFiles() {
        indentionLevel = 0;
    }

    private String indent() {
        String message = "";

        for (int i = 0; i < indentionLevel; i++) {
            message += " ";
        }
        return message;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) {
        logger.debug("Visiting file:" + file.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path directory, IOException e) throws IOException {
        indentionLevel -= indentionAmount;
        logger.debug(indent() + "Finished with the directory: " + directory.getFileName());
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path directory, BasicFileAttributes attributes) throws IOException {
        logger.debug(indent() + "About to traverse the directory: " + directory.getFileName());
        indentionLevel += indentionAmount;
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        logger.debug("A file traversal error ocurred");
        return super.visitFileFailed(file, exc);
    }
}
