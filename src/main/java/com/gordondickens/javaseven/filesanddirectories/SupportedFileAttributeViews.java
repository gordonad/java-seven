package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;

public class SupportedFileAttributeViews {
    private static final Logger logger = LoggerFactory.getLogger(SupportedFileAttributeViews.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");
        FileSystem fileSystem = path.getFileSystem();
        Set<String> supportedViews = fileSystem.supportedFileAttributeViews();

        for (String view : supportedViews) {
            logger.debug(view);
        }
    }
}


//There's More Example 1
//        try {
//        FileStore fileStore = Files.getFileStore(path);
//            logger.debug("FileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    FileAttributeView.class));
//            logger.debug("BasicFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    BasicFileAttributeView.class));
//            logger.debug("FileOwnerAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    FileOwnerAttributeView.class));
//            logger.debug("AclFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    AclFileAttributeView.class));
//            logger.debug("PosixFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    PosixFileAttributeView.class));
//            logger.debug("UserDefinedFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    UserDefinedFileAttributeView.class));
//            logger.debug("DosFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    DosFileAttributeView.class));
//        } catch (IOException ex) {
//            logger.debug("Attribute view not supported");
//        }

//There's More Example 2
//        try {
//            FileStore fileStore = Files.getFileStore(path);
//            logger.debug("FileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "file"));
//            logger.debug("BasicFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "basic"));
//            logger.debug("FileOwnerAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "owner"));
//            logger.debug("AclFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "acl"));
//            logger.debug("PosixFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "posix"));
//            logger.debug("UserDefinedFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "user"));
//            logger.debug("DosFileAttributeView supported: " + fileStore.supportsFileAttributeView(
//                    "dos"));
//        } catch (IOException ex) {
//            logger.debug("Attribute view not supported");
//        }
//}
//        }
