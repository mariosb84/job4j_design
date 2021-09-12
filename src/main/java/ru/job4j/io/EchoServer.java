
package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                        while (in.ready()) {
                        System.out.println(str);
                        if (str.contains("Exit")) {
                            System.out.println("Server is closed");
                            out.write("HTTP/1.1 400 OK\r\n\r\n".getBytes());
                            server.close();
                            break;
                        }
                        if (str.contains("Hello")) {
                            out.write("Hello!\r\n\r\n".getBytes());
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            break;
                        }
                        if (!str.contains("Hello") && !(str.contains("Exit"))) {
                            out.write("What?\r\n\r\n".getBytes());
                            out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            break;
                        }
                    }
                    out.flush();
                } catch (Exception e) {
                    LOG.error("Exception in log OutputStream out", e);
                }
            }
        } catch (Exception e) {
            LOG.error("Exception in log ServerSocket server", e);
        }
    }
}
