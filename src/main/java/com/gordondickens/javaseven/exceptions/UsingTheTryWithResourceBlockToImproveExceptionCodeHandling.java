package com.gordondickens.javaseven.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsingTheTryWithResourceBlockToImproveExceptionCodeHandling {
    private static final Logger logger = LoggerFactory.getLogger(UsingTheTryWithResourceBlockToImproveExceptionCodeHandling.class);

    public static void main(String[] args) {
        try (BufferedReader inputReader = Files.newBufferedReader(
                Paths.get(new URI("file:////home/docs/users.txt")),
                Charset.defaultCharset());
             BufferedWriter outputWriter = Files.newBufferedWriter(
                     Paths.get(new URI("file:////home/docs/users.bak")),
                     Charset.defaultCharset())) {
            String inputLine;
            while ((inputLine = inputReader.readLine()) != null) {
                outputWriter.write(inputLine);
                outputWriter.newLine();
            }
            logger.debug("Copy complete!");
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }

        //There's More: Structing Issues When Using the Try-With_Resource
        //Technique
//        Path path = null;
//        try {
//            path = Paths.get(new URI("file:////home/docs/users.txt"));
//        } catch (URISyntaxException e) {
//            logger.debug("Bad URI");
//        }
//
//        try (BufferedReader inputReader = Files.newBufferedReader(path, Charset.defaultCharset())) {
//            String inputLine;
//            while ((inputLine = inputReader.readLine()) != null) {
//                logger.debug(inputLine);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

//        try (BufferedReader inputReader = Files.newBufferedReader(
//                        Paths.get(new URI("file:////home/docs/users.txt")), Charset.defaultCharset())) {
//            String inputLine;
//            while ((inputLine = inputReader.readLine()) != null) {
//                logger.debug(inputLine);
//            }
//        } catch (IOException | URISyntaxException ex) {
//            ex.printStackTrace();
//        }

//        try {
//            Path path = Paths.get("users.txt");
//            BufferedReader inputReader =
//                    Files.newBufferedReader(path, Charset.defaultCharset());
//            String inputLine;
//            while ((inputLine = inputReader.readLine()) != null) {
//                logger.debug(inputLine);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }
}
