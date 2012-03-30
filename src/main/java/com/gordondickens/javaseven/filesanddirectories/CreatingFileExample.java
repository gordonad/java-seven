package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class CreatingFileExample {
    private static final Logger logger = LoggerFactory.getLogger(CopyingFileExample.class);

    public static void main(String[] args) {

        Path newPath = FileSystems.getDefault().getPath("\\home\\docs\\");
        try {
            Path myDirectory = Files.createDirectory(newPath);
            logger.debug("Directory created successfully!");
        } catch (FileAlreadyExistsException a) {
            logger.debug("Directory already exists!");
        } catch (IOException e) {
            logger.debug("IO Exception.");
        }
        Path newFile = FileSystems.getDefault().getPath("\\home\\docs\\users.txt");
        try {
            Files.createFile(newFile);
            logger.debug("File created successfully!");
        } catch (FileAlreadyExistsException a) {
            logger.debug("File already exists!");
        } catch (IOException e) {
            logger.debug("IO Exception.");
        }
        try {
            Files.delete(newFile);
            logger.debug("File deleted successfully!");
        } catch (IOException e) {
            logger.debug("IO Exception.");
        }
        try {
            Files.delete(newPath);
            logger.debug("Directory deleted successfully!");
        } catch (IOException e) {
            logger.debug("IO Exception.");
        }
        //There's More:
//        Path directoriesPath = Paths.get("/home/test/subtest/subsubtest");
//        try {
//            Path testDirectory = Files.createDirectories(directoriesPath);
//            logger.debug("Directory sequence created successfully!");
//        } catch (IOException e) {
//            logger.debug("IO Exception.");
//        }


    }
}
