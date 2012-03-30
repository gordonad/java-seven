package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;

public class GettingFileSystemInformation {
    private static final Logger logger = LoggerFactory.getLogger(GettingFileSystemInformation.class);

    public static void main(String[] args) {
        FileSystem fileSystem = FileSystems.getDefault();
        FileSystemProvider provider = fileSystem.provider();

        logger.debug("Provider: " + provider.toString());
        logger.debug("Open: " + fileSystem.isOpen());
        logger.debug("Read Only: " + fileSystem.isReadOnly());

        Iterable<Path> rootDirectories = fileSystem.getRootDirectories();
        logger.debug("");
        logger.debug("Root Directories");
        for (Path path : rootDirectories) {
            logger.debug(path.toString());
        }

        Iterable<FileStore> fileStores = fileSystem.getFileStores();
        logger.debug("");
        logger.debug("File Stores");
        for (FileStore fileStore : fileStores) {
            logger.debug(fileStore.name());
        }
    }
}
