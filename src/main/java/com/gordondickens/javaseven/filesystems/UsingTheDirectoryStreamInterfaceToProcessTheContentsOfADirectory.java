package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;

public class UsingTheDirectoryStreamInterfaceToProcessTheContentsOfADirectory {
    private static final Logger logger = LoggerFactory.getLogger(UsingTheDirectoryStreamInterfaceToProcessTheContentsOfADirectory.class);

    public static void main(String[] args) {
        Path directory = Paths.get("/home");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory)) {
            for (Path file : directoryStream) {
                logger.debug(file.getFileName().toString());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }
    }
}
