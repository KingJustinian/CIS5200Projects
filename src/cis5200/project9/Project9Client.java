package cis5200.project9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

/**
 * CIS5200-W01
 * Project 9
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project9Client {
    public static void main(String[] args) throws IOException {
 
        String hostName = "localhost";
        int portNumber = 2525;
 
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
        ) {
            sendLoginInfo(out);
            String serverReply = in.readLine();
            System.out.println("Login Result: " + serverReply);
            while (serverReply.startsWith("Login invalid")) {
                sendLoginInfo(out);
                serverReply = in.readLine();
                System.out.println("Login Result: " + serverReply);
            }
            
            String filename = JOptionPane.showInputDialog("Enter a filename to retrieve: ");
            out.println(filename);
            
            serverReply = in.readLine();
            System.out.println("File retrieval result: " + serverReply);
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
    
    private static void sendLoginInfo(PrintWriter out) {
        String username = JOptionPane.showInputDialog("Enter the username");
        String password = JOptionPane.showInputDialog("Enter the password");
        out.println("username=" + username + "&password=" + password);
    }
}
