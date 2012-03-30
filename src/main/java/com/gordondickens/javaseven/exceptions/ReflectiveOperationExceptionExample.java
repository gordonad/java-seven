package com.gordondickens.javaseven.exceptions;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReflectiveOperationExceptionExample {

    public static void main(String[] args) {
        try {
            Files.delete(Paths.get(new URI("file:///tmp.txt")));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }
    }
}
