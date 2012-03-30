package com.gordondickens.javaseven.streamio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.EnumSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ReadingFromAFileUsingTheAsynchronousFileChannelCllass {
    private static final Logger logger = LoggerFactory.getLogger(ReadingFromAFileUsingTheAsynchronousFileChannelCllass.class);

    public static void main(String args[]) {
        ExecutorService pool = new ScheduledThreadPoolExecutor(3);
        try (AsynchronousFileChannel fileChannel =
                     AsynchronousFileChannel.open(Paths.get("/home/docs/items.txt"),
                             EnumSet.of(StandardOpenOption.READ), pool)) {
            logger.debug("Main Thread ID: " + Thread.currentThread().getId());

            CompletionHandler<Integer, ByteBuffer> handler =
                    new CompletionHandler<Integer, ByteBuffer>() {

                        @Override
                        public synchronized void completed(Integer result, ByteBuffer attachment) {
                            String message = "";
                            for (int i = 0; i < attachment.limit(); i++) {
                                message += ((char) attachment.get(i));
                            }
                            logger.debug("result");
                            logger.debug("CompletionHandler Thread ID: {}",
                                    Thread.currentThread().getId());
                        }

                        @Override
                        public void failed(Throwable e, ByteBuffer attachment) {
                            logger.debug("Failed");
                        }
                    };
            final int bufferCount = 5;
            ByteBuffer buffers[] = new ByteBuffer[bufferCount];
            for (int i = 0; i < bufferCount; i++) {
                buffers[i] = ByteBuffer.allocate(10);
                fileChannel.read(buffers[i], i * 10, buffers[i], handler);
            }
            pool.awaitTermination(1, TimeUnit.SECONDS);

            logger.debug("Byte Buffers");
            String message = "";

            for (ByteBuffer byteBuffer : buffers) {
                for (int i = 0; i < byteBuffer.limit(); i++) {
                    message += ((char) byteBuffer.get(i));
                }
                logger.debug(message);
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
