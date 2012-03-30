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

public class SetACLExample {
    private static final Logger logger = LoggerFactory.getLogger(SetACLExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");
        try {
            AclFileAttributeView view = Files.getFileAttributeView(path, AclFileAttributeView.class);
            List<AclEntry> aclEntryList = view.getAcl();
            displayAclEntries(aclEntryList);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void displayAclEntries(List<AclEntry> aclEntryList) {
        logger.debug("ACL Entry List size: " + aclEntryList.size());
        for (AclEntry entry : aclEntryList) {
            logger.debug("User Principal Name: " + entry.principal().getName());
            logger.debug("ACL Entry Type: " + entry.type());
            displayEntryFlags(entry.flags());
            displayPermissions(entry.permissions());
        }
    }

    private static void displayPermissions(Set<AclEntryPermission> permissionSet) {
        if (permissionSet.isEmpty()) {
            logger.debug("No Permissions present");
        } else {
            logger.debug("Permissions");
            String message = "";
            for (AclEntryPermission permission : permissionSet) {
                message+= permission.name() + " ";
            }
            logger.debug(message);
        }
    }

    private static void displayEntryFlags(Set<AclEntryFlag> flagSet) {
        if (flagSet.isEmpty()) {
            logger.debug("No ACL Entry Flags present");
        } else {
            logger.debug("ACL Entry Flags");
            String message = "";

            for (AclEntryFlag flag : flagSet) {
                message += flag.name() + " ";
            }
            logger.debug(message);
        }
    }

}
