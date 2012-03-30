package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;

public class MapAttributesExample {
    private static final Logger logger = LoggerFactory.getLogger(MapAttributesExample.class);

    public static void main(String[] args) throws Exception {
        Path path = Paths.get("/home/docs/users.txt");

//        try {
        Map<String, Object> attrsMap = Files.readAttributes(path, "*");
        Set<String> keys = attrsMap.keySet();

        for (String attribute : keys) {
            logger.debug(attribute + ": "
                    + Files.getAttribute(path, attribute));
        }
//        }
    }

}