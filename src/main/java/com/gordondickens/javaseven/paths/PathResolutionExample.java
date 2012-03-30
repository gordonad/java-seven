package com.gordondickens.javaseven.paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathResolutionExample {
    private static final Logger logger = LoggerFactory.getLogger(PathResolutionExample.class);

    public static void main(String[] args) {
        Path rootPath = Paths.get("/home/docs");
        Path partialPath = Paths.get("users.txt");
        Path resolvedPath = rootPath.resolve(partialPath);

        //There's More: alternate examples
        //Path resolvedPath = rootPath.resolve("backup/users.txt");
        //Path resolvedPath = rootPath.resolve("users.txt");

        //There's More: Improper Use examples
        //Path resolvedPath = partialPath.resolve(rootPath);
        //Path resolvedPath = partialPath.resolve(partialPath);
        //Path resolvedPath = rootPath.resolve(rootPath);

        logger.debug("rootPath: " + rootPath);
        logger.debug("partialPath: " + partialPath);
        logger.debug("resolvedPath: " + resolvedPath);
        logger.debug("Resolved absolute path: " + resolvedPath.toAbsolutePath());

        //There's More: Resolved Siblings
//        Path rootPath = Paths.get("/home/music/");
//        Path resolvedPath = rootPath.resolve(partialPath);
//        resolvedPath = rootPath.resolve("tmp/Robot Brain A.mp3");
//        logger.debug("rootPath: " + rootPath);
//        logger.debug("resolvedPath: " + resolvedPath);
//        logger.debug();
//
//        resolvedPath = rootPath.resolveSibling("tmp/Robot Brain A.mp3");
//        logger.debug("rootPath: " + rootPath);
//        logger.debug("resolvedPath: " + resolvedPath);

    }
}
