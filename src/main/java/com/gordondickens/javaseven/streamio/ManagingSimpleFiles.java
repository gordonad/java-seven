package com.gordondickens.javaseven.streamio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ManagingSimpleFiles {
    private static final Logger logger = LoggerFactory.getLogger(ManagingSimpleFiles.class);

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/docs/users.txt");
        byte[] contents = Files.readAllBytes(path);
        String result = "";
        for (byte b : contents) {
            result += ((char) b);
        }
        logger.debug(result);
        // Writing to a simple file
        Path newPath = Paths.get("/home/docs/newUsers.txt");
        byte[] newContents = "Christopher".getBytes();

//            Files.write(newPath, contents, StandardOpenOption.CREATE);
//            Files.write(newPath, newContents, StandardOpenOption.APPEND);

        // Reading all of the lines of a file returned as a list
//            Path path = Paths.get("/home/docs/users.txt");
//            List<String> contents = Files.readAllLines(path, Charset.defaultCharset());
//            for (String b : contents) {
//                logger.debug(b);
//            }

    }
}
