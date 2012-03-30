package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;

public class GetOwnerExample {
    private static final Logger logger = LoggerFactory.getLogger(GetOwnerExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");
        try {
            FileOwnerAttributeView view = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
            UserPrincipal userPrincipal = view.getOwner();
            logger.debug(userPrincipal.getName());

            //There's More Example
//            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
//            userPrincipal = lookupService.lookupPrincipalByName("users");
//            view.setOwner(userPrincipal);
//            logger.debug("UserPrincipal set: " + userPrincipal.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
