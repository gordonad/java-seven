package com.gordondickens.javaseven;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsingStringLiteralsInSwitchStatements {
    private static final Logger logger = LoggerFactory.getLogger(UsingStringLiteralsInSwitchStatements.class);

    private static boolean verbose = false;
    private static boolean logging = false;
    private static boolean displayHelp = false;

    public static void main(String[] args) {
        for (String argument : args) {
            switch (argument) {
                case "-verbose":
                case "-v":
                    verbose = true;
                    break;
                case "-log":
                    logging = true;
                    break;
                case "-help":
                    displayHelp = true;
                    break;
                default:
                    logger.debug("Illegal command line argument");
            }
            displayApplicationSettings();
        }
    }

    private static void displayApplicationSettings() {
        logger.debug("Application Settings");
        logger.debug("Verbose: " + verbose);
        logger.debug("Logging: " + logging);
        logger.debug("Help: " + displayHelp);
    }
}
