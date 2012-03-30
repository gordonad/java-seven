package com.gordondickens.javaseven.paths;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.Assert.*;

public class ComparingPathsTests {
    private static final Logger logger = LoggerFactory.getLogger(ComparingPathsTests.class);

    @Test
    public void main() {
        Path path1 = null;
        Path path2 = null;
        Path path3 = null;

        path1 = Paths.get("/code/java-seven/src/test/resources/someData.txt");
        path2 = Paths.get("/code/java-seven/src/test/resources/someData.txt");
        path3 = Paths.get("/code/java-seven/src/test/resources/someOtherData.txt");

        assertEquals(path1, path2);
        assertFalse(path1.equals(path3));

        assertTrue(path1.compareTo(path2) == 0);
        assertFalse(path1.compareTo(path3) == 0);
        try {
            assertTrue(Files.isSameFile(path1, path2));
            assertFalse(Files.isSameFile(path1, path3));
        } catch (IOException e) {
            logger.error("", e);
        }
    }
}
