package com.gordondickens.javaseven.streamio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class RandomAccessIOUsingTheSeekableByteChannel {
    private static final Logger logger = LoggerFactory.getLogger(RandomAccessIOUsingTheSeekableByteChannel.class);

    public static void main(String[] args) throws IOException {
        int bufferSize = 8;
        Path path = Paths.get("/home/docs/users.txt");

//        try (SeekableByteChannel sbc = Files.newByteChannel(path)) {
//            ByteBuffer buffer = ByteBuffer.allocate(bufferSize);
//
//            sbc.position(4);
//            sbc.read(buffer);
//            for(int i=0; i<5; i++) {
//                System.out.print((char)buffer.get(i));
//            }
//            logger.debug();
//
//            buffer.clear();
//            sbc.position(0);
//            sbc.read(buffer);
//            for(int i=0; i<4; i++) {
//                System.out.print((char)buffer.get(i));
//            }
//            logger.debug();

        // Processing the contents of the entire file
        // Read the entire file
//            logger.debug("Contents of File");
//            sbc.position(0);
//            buffer = ByteBuffer.allocate(bufferSize);
//            String encoding = System.getProperty("file.encoding");
//            int numberOfBytesRead = sbc.read(buffer);
//            logger.debug("Number of bytes read: " + numberOfBytesRead);
//            while (numberOfBytesRead > 0) {
//                buffer.rewind();
//                System.out.print("[" + Charset.forName(encoding).decode(buffer) + "]");
//                buffer.flip();
//                numberOfBytesRead = sbc.read(buffer);
//                logger.debug("\nNumber of bytes read: " + numberOfBytesRead);
//            }

        // Writing to a file using the SeekableByteChannel interface
//        final String newLine = System.getProperty("line.separator");
//        try (SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.APPEND)) {
//            String output = newLine + "Paul" + newLine + "Carol" + newLine + "Fred";
//            ByteBuffer buffer = ByteBuffer.wrap(output.getBytes());
//            sbc.write(buffer); 
//        } 
        // Query the position
        final String newLine = System.getProperty("line.separator");
        try (SeekableByteChannel sbc = Files.newByteChannel(path, StandardOpenOption.WRITE)) {
            ByteBuffer buffer;
            long position = sbc.size();
            sbc.position(position);
            logger.debug("Position: " + sbc.position());

            buffer = ByteBuffer.wrap((newLine + "Paul").getBytes());
            sbc.write(buffer);
            logger.debug("Position: " + sbc.position());
            buffer = ByteBuffer.wrap((newLine + "Carol").getBytes());
            sbc.write(buffer);
            logger.debug("Position: " + sbc.position());
            buffer = ByteBuffer.wrap((newLine + "Fred").getBytes());
            sbc.write(buffer);
            logger.debug("Position: " + sbc.position());
        }

    }

}
