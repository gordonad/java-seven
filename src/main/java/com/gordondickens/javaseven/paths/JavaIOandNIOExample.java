package com.gordondickens.javaseven.paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class JavaIOandNIOExample {
    private static final Logger logger = LoggerFactory.getLogger(JavaIOandNIOExample.class);

    public static void main(String[] args) {
        try {
            Path path =
                    Paths.get(new URI("file:////home/docs/users.txt"));
            File file = new File("\\home\\docs\\users.txt");
            Path toPath = file.toPath();
            logger.debug(Boolean.toString(toPath.equals(path)));
        } catch (URISyntaxException e) {
            logger.debug("Bad URI");
        }

    }
}

