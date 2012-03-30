package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class CopyingFileExample {
    private static final Logger logger = LoggerFactory.getLogger(CopyingFileExample.class);

    public static void main(String[] args) {
        Path newFile = FileSystems.getDefault().getPath("/home/docs/newFile.txt");
        Path copiedFile = FileSystems.getDefault().getPath("/home/docs/copiedFile.txt");

        try {
//            Files.createFile(newFile);
//            logger.debug("File created successfully!");
//            Files.copy(newFile, copiedFile);
//            logger.debug("File copied successfully!");
            Files.copy(newFile, copiedFile, StandardCopyOption.REPLACE_EXISTING);
            logger.debug("File copied successfully!");
        } catch (IOException e) {
            logger.debug("IO Exception.");
        }

        //There's More: Copying Symbolic Links
//        Path originalLinkedFile = FileSystems.getDefault().getPath("/home/music/users.txt");
//        Path newLinkedFile = FileSystems.getDefault().getPath("/home/music/users2.txt");
//        try {
//            Files.copy(originalLinkedFile, newLinkedFile);
//            logger.debug("Symbolic link file copied successfully!");
//        } catch (IOException e) {
//            logger.debug("IO Exception.");
//        }
        //There's More: Copy Directory
//        Path originalDirectory = FileSystems.getDefault().getPath("/home/docs");
//        Path newDirectory = FileSystems.getDefault().getPath("/home/tmp");
//        try {
//            Files.copy(originalDirectory, newDirectory);
//            logger.debug("Directory copied successfully!");
//        } catch (IOException e) {
//            logger.error("", e);
//        }

        //There's More: Copying from an Input Stream
//        Path newFile = FileSystems.getDefault().getPath("/home/docs/java7WebSite.html");
//        URI url = URI.create("http://jdk7.java.net/");
//        try (InputStream inputStream = url.toURL().openStream()) {
//            Files.copy(inputStream, newFile);
//            logger.debug("Site copied successfully!");
//        } catch (MalformedURLException ex) {
//            ex.printStackTrace();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

        //There's More: Copying From and Output Stream
//        Path sourceFile = FileSystems.getDefault().getPath("/home/docs/users.txt");
//        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
//            Files.copy(sourceFile, outputStream);
//            byte arr[] = outputStream.toByteArray();
//            logger.debug("The contents of " + sourceFile.getFileName());
//            String result = "";
//            for (byte data : arr) {
//                result += ((char) data);
//            }
//            logger.debug(result);
//        } catch (IOException | MalformedURLException ex) {
//            ex.printStackTrace();
//        }


    }
}
