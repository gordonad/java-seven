package com.gordondickens.javaseven.extendedssl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AlgorithmConstraints;
import java.util.Date;

public class EchoServer {
    private static final Logger logger = LoggerFactory.getLogger(EchoServer.class);

    public EchoServer() {
        try {
            SSLServerSocketFactory sslServerSocketFactory =
                    (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket sslServerSocket =
                    (SSLServerSocket) sslServerSocketFactory.createServerSocket(9999);
            logger.debug("Waiting for a client ...");
            SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();

            SSLParameters parameters = sslSocket.getSSLParameters();
            parameters.setAlgorithmConstraints(new SimpleConstraints());

            AlgorithmConstraints constraints = parameters.getAlgorithmConstraints();
            logger.debug("Constraint: " + constraints);

            String endPoint = parameters.getEndpointIdentificationAlgorithm();
            logger.debug("End Point: " + endPoint);

            logger.debug("Local Supported Signature Algorithms");
            if (sslSocket.getSession() instanceof ExtendedSSLSession) {
                ExtendedSSLSession extendedSSLSession =
                        (ExtendedSSLSession) sslSocket.getSession();
                String alogrithms[] =
                        extendedSSLSession.getLocalSupportedSignatureAlgorithms();
                for (String algorithm : alogrithms) {
                    logger.debug("Algortihm: " + algorithm);
                }
            }

            logger.debug("Peer Supported Signature Algorithms");
            if (sslSocket.getSession() instanceof ExtendedSSLSession) {
                String alogrithms[] = ((ExtendedSSLSession) sslSocket.getSession()).getPeerSupportedSignatureAlgorithms();
                for (String algorithm : alogrithms) {
                    logger.debug("Algortihm: " + algorithm);
                }
            }

            InputStream inputstream = sslSocket.getInputStream();
            InputStreamReader inputstreamreader = new InputStreamReader(inputstream);
            BufferedReader bufferedreader = new BufferedReader(inputstreamreader);

            SSLSession session = sslSocket.getHandshakeSession();
            if (session != null) {
                logger.debug("Last accessed: " + new Date(session.getLastAccessedTime()));
            }

            String string = null;
            while ((string = bufferedreader.readLine()) != null) {
                logger.debug(string);
                System.out.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }

    }

    public static void main(String[] arstring) {
        new EchoServer();
    }

}
