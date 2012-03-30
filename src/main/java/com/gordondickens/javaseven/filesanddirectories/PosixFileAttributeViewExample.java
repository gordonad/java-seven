package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Set;

public class PosixFileAttributeViewExample {
    private static final Logger logger = LoggerFactory.getLogger(PosixFileAttributeViewExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("home/docs/users.txt");
        listPermissions(path);
        removePermission(path, PosixFilePermission.OWNER_EXECUTE);
        setPermission(path, PosixFilePermission.OWNER_EXECUTE);
        listPermissions(path);
        setGroupPrincipal(path, "mary", "mary");
    }

    private static void listPermissions(Path path) {
        try {

            logger.debug("Permission for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();

            logger.debug("Group: " + attributes.group().getName());
            logger.debug("Owner: " + attributes.owner().getName());

            Set<PosixFilePermission> permissions = attributes.permissions();

            String message = "Permissions: ";
            for (PosixFilePermission permission : permissions) {
                message += (permission.name() + " ");
            }
            logger.debug(message);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void setPermission(Path path, PosixFilePermission permission) {
        try {

            logger.debug("\nSetting permission for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();

            Set<PosixFilePermission> permissions = attributes.permissions();
            permissions.add(permission);

            view.setPermissions(permissions);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void removePermission(Path path, PosixFilePermission permission) {
        try {
            logger.debug("\nRemoving permission for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();

            Set<PosixFilePermission> permissions = attributes.permissions();
            permissions.remove(permission);

            view.setPermissions(permissions);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void setGroupPrincipal(Path path, String userName, String groupName) {
        try {
            logger.debug("Setting owner for " + path.getFileName());
            FileSystem fileSystem = path.getFileSystem();
            PosixFileAttributeView view = Files.getFileAttributeView(path, PosixFileAttributeView.class);

            PosixFileAttributes attributes = view.readAttributes();
            logger.debug("Old Group: " + attributes.group().getName());
            logger.debug("Old Owner: " + attributes.owner().getName());

            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
            UserPrincipal userPrincipal = lookupService.lookupPrincipalByName(userName);
            GroupPrincipal groupPrincipal = lookupService.lookupPrincipalByGroupName(groupName);
            view.setGroup(groupPrincipal);
            view.setOwner(userPrincipal);

            attributes = view.readAttributes();
            logger.debug("New Group: " + attributes.group().getName());
            logger.debug("New Owner: " + attributes.owner().getName());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}