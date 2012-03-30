package com.gordondickens.javaseven.streamio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.WritePendingException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingToAFileUsingTheAsynchronousFileChannelClass {
    private static final Logger logger = LoggerFactory.getLogger(WritingToAFileUsingTheAsynchronousFileChannelClass.class);

    public static void main(String[] args) {
        try (AsynchronousFileChannel fileChannel =
                     AsynchronousFileChannel.open(Paths.get("/home/docs/asynchronous.txt"),
                             StandardOpenOption.READ, StandardOpenOption.WRITE,
                             StandardOpenOption.CREATE)) {
            CompletionHandler<Integer, Object> handler =
                    new CompletionHandler<Integer, Object>() {

                        @Override
                        public void completed(Integer result, Object attachment) {
                            logger.debug("Attachment: " + attachment
                                    + " " + result + " bytes written");
                            logger.debug("CompletionHandler Thread ID: "
                                    + Thread.currentThread().getId());
                        }

                        @Override
                        public void failed(Throwable e, Object attachment) {
                            System.err.println("Attachment: "
                                    + attachment + " failed with:");
                            logger.error("", e);
                        }
                    };

            logger.debug("Main Thread ID: " + Thread.currentThread().getId());
            fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0, "First Write", handler);
            fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0, "Second Write", handler);

            // There's more section
//            Future<Integer> writeFuture1 = fileChannel.write(ByteBuffer.wrap("Sample".getBytes()), 0);
//            Future<Integer> writeFuture2 = fileChannel.write(ByteBuffer.wrap("Box".getBytes()), 0);
//
//            int result;
//            try {
//                result = writeFuture1.get();
//                logger.debug("Sample write completed with " + result + " bytes written");
//                result = writeFuture2.get();
//                logger.debug("Box write completed with " + result + " bytes written");
//            } catch (InterruptedException ex) {
//                ex.printStackTrace();
//            } catch (ExecutionException ex) {
//                ex.printStackTrace();
//            }

        } catch (WritePendingException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
