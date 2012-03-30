package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;

public class UnderstandingTheZipFileSystemProvider {
    private static final Logger logger = LoggerFactory.getLogger(UnderstandingTheZipFileSystemProvider.class);

    public static void main(String[] args) {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("create", "true");
        try {
            URI zipFile = URI.create("jar:file:/home.zip");
            try (FileSystem zipFileSys = FileSystems.newFileSystem(zipFile, attributes);) {
                Path path = zipFileSys.getPath("docs");
                Files.createDirectory(path);
                try (DirectoryStream<Path> directoryStream =
                             Files.newDirectoryStream(zipFileSys.getPath("/"));) {
                    for (Path file : directoryStream) {
                        logger.debug(file.getFileName().toString());
                    }
                }
            }
        } catch (IOException e) {
            logger.error("", e);
        }

    }
}
