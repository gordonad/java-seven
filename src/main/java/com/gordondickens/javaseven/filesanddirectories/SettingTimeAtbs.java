package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.Calendar;

public class SettingTimeAtbs {
    private static final Logger logger = LoggerFactory.getLogger(SettingTimeAtbs.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");

        BasicFileAttributeView view = Files.getFileAttributeView(path, BasicFileAttributeView.class);
        try {
            FileTime lastModifedTime;
            FileTime lastAccessTime;
            FileTime createTime;

            BasicFileAttributes attributes = view.readAttributes();
            lastModifedTime = attributes.lastModifiedTime();
            createTime = attributes.creationTime();

            long currentTime = Calendar.getInstance().getTimeInMillis();
            lastAccessTime = FileTime.fromMillis(currentTime);

            view.setTimes(lastModifedTime, lastAccessTime, createTime);
            logger.debug(attributes.lastAccessTime().toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
