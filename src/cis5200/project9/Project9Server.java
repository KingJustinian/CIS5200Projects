package cis5200.project9;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * CIS5200-W01 Project 9 Justin Burden
 *
 * @author Justin Burden
 */
public class Project9Server {

    public static void main(String[] args) {
        int portNumber = 2525;

        boolean listening = true;

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (listening) {
                new Project9MultiServerThread(serverSocket.accept()).start();
            }
        } catch (IOException e) {
            System.err.println("Could not listen on port " + portNumber);
            System.exit(-1);
        }
    }
}
