package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.AclEntry;
import java.nio.file.attribute.AclEntryFlag;
import java.nio.file.attribute.AclEntryPermission;
import java.nio.file.attribute.AclFileAttributeView;
import java.util.List;
import java.util.Set;

public class ACLAttributeExample {
    private static final Logger logger = LoggerFactory.getLogger(ACLAttributeExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");
        try {
            AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
            List<AclEntry> aclEntryList = view.getAcl();
            for (AclEntry entry : aclEntryList) {
                logger.debug("User Principal Name: " + entry.principal().getName());
                logger.debug("ACL Entry Type: " + entry.type());
                displayEntryFlags(entry.flags());
                displayPermissions(entry.permissions());
            }
        } catch (IOException e) {
            logger.error("", e);
        }

        //There's More Example
//        try {
//            UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
//            GroupPrincipal groupPrincipal = lookupService.lookupPrincipalByGroupName("Administrators");
//            UserPrincipal userPrincipal = lookupService.lookupPrincipalByName("Richard");
//            logger.debug(groupPrincipal.getName());
//            logger.debug(userPrincipal.getName());
//        } catch (IOException e) {
//            logger.error("", e);
//        }

    }

    private static void displayPermissions(Set<AclEntryPermission> permissionSet) {
        if (permissionSet.isEmpty()) {
            logger.debug("No Permissions present");
        } else {
            logger.debug("Permissions");
            String result = "";
            for (AclEntryPermission permission : permissionSet) {
                result += permission.name() + " ";
            }
            logger.debug(result);
        }
    }

    private static void displayEntryFlags(Set<AclEntryFlag> flagSet) {
        if (flagSet.isEmpty()) {
            logger.debug("No ACL Entry Flags present");
        } else {
            logger.debug("ACL Entry Flags");
            String result = "";
            for (AclEntryFlag flag : flagSet) {
                result += flag.name() + " ";
            }
            logger.debug(result);
        }
    }
}
