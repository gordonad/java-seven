package com.gordondickens.javaseven.extendedssl;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class EchoClient {
    public static void main(String[] args) {
        try {
            SSLSocketFactory sslSocketFactory =
                    (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket)
                    sslSocketFactory.createSocket("localhost", 9999);

            InputStreamReader inputStreamReader =
                    new InputStreamReader(System.in);
            BufferedReader bufferedReader =
                    new BufferedReader(inputStreamReader);

            OutputStream outputStream = sslSocket.getOutputStream();
            OutputStreamWriter outputStreamWriter =
                    new OutputStreamWriter(outputStream);
            BufferedWriter bufferedwriter =
                    new BufferedWriter(outputStreamWriter);

            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedwriter.write(line + '\n');
                bufferedwriter.flush();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
