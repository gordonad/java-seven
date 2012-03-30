package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;

public class SettingOwnerExample {
    private static final Logger logger = LoggerFactory.getLogger(SettingOwnerExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");
        FileOwnerAttributeView view = Files.getFileAttributeView(path, FileOwnerAttributeView.class);
        try {
            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
            UserPrincipal userPrincipal = lookupService.lookupPrincipalByName("mary");

            view.setOwner(userPrincipal);
            logger.debug("Owner: " + view.getOwner().getName());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        //There's More: Using setOwner
//        Path path = Paths.get("/home/docs/users.txt");
//        try {
//            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
//            UserPrincipal userPrincipal = lookupService.lookupPrincipalByName("mary");
//
//            Files.setOwner(path, userPrincipal);
//            logger.debug("Owner: " + view.getOwner().getName());
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }
}
