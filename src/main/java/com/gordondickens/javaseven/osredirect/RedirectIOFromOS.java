package com.gordondickens.javaseven.osredirect;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class RedirectIOFromOS {
    private static final Logger logger = LoggerFactory.getLogger(RedirectIOFromOS.class);

    public static void main(String[] args) {
        try {
            File commands = new File("/Projects/ProcessCommands.txt");
            File output = new File("/Projects/ProcessLog.txt");
            File errors = new File("/Projects/ErrorLog.txt");

            ProcessBuilder pb = new ProcessBuilder("cmd");
            logger.debug(pb.redirectInput().toString());
            logger.debug(pb.redirectOutput().toString());
            logger.debug(pb.redirectError().toString());

            pb.redirectInput(commands);
            pb.redirectError(errors);
            pb.redirectOutput(output);
            logger.debug(pb.redirectInput().toString());
            logger.debug(pb.redirectOutput().toString());
            logger.debug(pb.redirectError().toString());

            pb.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
