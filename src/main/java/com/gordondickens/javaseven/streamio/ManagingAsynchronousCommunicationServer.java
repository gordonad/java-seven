package com.gordondickens.javaseven.streamio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class ManagingAsynchronousCommunicationServer {
    private static final Logger logger = LoggerFactory.getLogger(ManagingAsynchronousCommunicationServer.class);

    public static void main(String[] args) {
        try {
            final AsynchronousServerSocketChannel listener =
                    AsynchronousServerSocketChannel.open();
            InetSocketAddress address = new InetSocketAddress("localhost", 5000);
            listener.bind(address);

//            Set<SocketOption<?>> options = listener.supportedOptions();
//            for (SocketOption<?> socketOption : options) {
//                logger.debug(socketOption.toString() + ": " + listener.getOption(socketOption));
//            }

            listener.accept(null, new CompletionHandler<AsynchronousSocketChannel, Void>() {

                public void completed(AsynchronousSocketChannel channel, Void attribute) {
                    try {
                        logger.debug("Server: completed method executing");
                        while (true) {
                            ByteBuffer buffer = ByteBuffer.allocate(32);
                            Future<Integer> readFuture = channel.read(buffer);
                            Integer number = readFuture.get();
                            logger.debug("Server: Message received: " + new String(buffer.array()));
                        }

                    } catch (InterruptedException | ExecutionException ex) {
                        ex.printStackTrace();
                    }
                }

                public void failed(Throwable ex, Void atttribute) {
                    logger.debug("Server: CompletionHandler exception");
                    ex.printStackTrace();
                }
            });
            while (true) {
                // wait
            }

        } catch (IOException ex) {

            // Using the Future object in a server
//            Future<AsynchronousSocketChannel> future = listener.accept();
//            AsynchronousSocketChannel worker = future.get();
//
//            while (true) {
//                // Wait
//                logger.debug("Server: Receiving ...");
//                ByteBuffer buffer = ByteBuffer.allocate(32);
//                Future<Integer> readFuture = worker.read(buffer);
//                Integer number = readFuture.get();
//                logger.debug("Server: Message received: " + new String(buffer.array()));
//            }
//        } catch (IOException | InterruptedException | ExecutionException ex) {
            ex.printStackTrace();
        }
    }
}
