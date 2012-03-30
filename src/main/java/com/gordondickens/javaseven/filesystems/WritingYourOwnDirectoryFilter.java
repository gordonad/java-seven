package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;

public class WritingYourOwnDirectoryFilter {
    private static final Logger logger = LoggerFactory.getLogger(WritingYourOwnDirectoryFilter.class);

    public static void main(String[] args) {
        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>() {

            public boolean accept(Path file) throws IOException {
                return (Files.isHidden(file));
            }
        };

        Path directory = Paths.get("/Windows");
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(directory, filter)) {
            for (Path file : directoryStream) {
                logger.debug(file.getFileName().toString());
            }
        } catch (IOException | DirectoryIteratorException ex) {
            ex.printStackTrace();
        }

    }
}
