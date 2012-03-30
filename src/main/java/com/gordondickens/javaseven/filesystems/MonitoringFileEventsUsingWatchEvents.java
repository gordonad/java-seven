package com.gordondickens.javaseven.filesystems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;

public class MonitoringFileEventsUsingWatchEvents {
    private static final Logger logger = LoggerFactory.getLogger(MonitoringFileEventsUsingWatchEvents.class);

    public static void main(String[] args) {
        try {
            FileSystem fileSystem = FileSystems.getDefault();
            WatchService watchService = fileSystem.newWatchService();
            Path directory = Paths.get("/home/docs");
            WatchEvent.Kind<?>[] events = {
                    StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_DELETE,
                    StandardWatchEventKinds.ENTRY_MODIFY};
            directory.register(watchService, events);
            while (true) {
                logger.debug("Waiting for a watch event");
                WatchKey watchKey = watchService.take();

                logger.debug("Path being watched: " + watchKey.watchable());

                if (watchKey.isValid()) {
                    for (WatchEvent<?> event : watchKey.pollEvents()) {
                        logger.debug("Kind: " + event.kind());
                        logger.debug("Context: " + event.context());
                        logger.debug("Count: " + event.count());
                    }

                    boolean valid = watchKey.reset();
                    if (!valid) {
                        // The watchKey is not longer registered
                    }
                }
            }

        } catch (InterruptedException | IOException ex) {
            ex.printStackTrace();
        }

    }
}
