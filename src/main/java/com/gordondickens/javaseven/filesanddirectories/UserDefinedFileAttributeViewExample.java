package com.gordondickens.javaseven.filesanddirectories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserDefinedFileAttributeView;

public class UserDefinedFileAttributeViewExample {
    private static final Logger logger = LoggerFactory.getLogger(UserDefinedFileAttributeViewExample.class);

    public static void main(String[] args) {
        Path path = Paths.get("/home/docs/users.txt");
        try {
            UserDefinedFileAttributeView view = Files.getFileAttributeView(path, UserDefinedFileAttributeView.class);
            view.write("publishable", Charset.defaultCharset().encode("true"));
            logger.debug("Publishable set");

            // There's more section
//            String name = "publishable";
//            ByteBuffer buffer = ByteBuffer.allocate(view.size(name));
//            view.read(name, buffer);
//            buffer.flip();
//            String value = Charset.defaultCharset().decode(buffer).toString();
//            logger.debug(value);

        } catch (IOException e) {
            logger.error("", e);
        }
    }

}