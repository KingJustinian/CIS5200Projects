package cis5200.project9;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CIS5200-W01
 * Project 9
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project9MultiServerThread extends Thread{
  
    private Socket socket = null;
    private Project9AuthenticationProtocol authenticator = null;
 
    public Project9MultiServerThread(Socket socket) {
        super("Project9MultiServerThread");
        this.socket = socket;
        authenticator = new Project9AuthenticationProtocol();
    }
    
    public void run() {         
        try ( 
            PrintWriter out =
                new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
        ) {
            boolean isLoggedIn = false;
            
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                
                if (isLoggedIn) {
                    String enteredFilename = inputLine;
                    File enteredFile = new File(enteredFilename);
                    if (!enteredFile.exists()) {
                        out.println("File didn't exist: " + enteredFile.getAbsolutePath());
                    } else if (enteredFilename.equalsIgnoreCase(Project9AuthenticationProtocol.
                            AUTHENTICATION_FILENAME)) {
                        out.println("Authentication file cannot be opened");
                    } else {
                        byte[] fileContent = Files.readAllBytes(Paths.get(enteredFile.getAbsolutePath()));
                        String fileContentStr = new String(fileContent);
                        String formattedFileContent = fileContentStr.replace("\n", " ");
                        out.println("File content: " + formattedFileContent);
                    }
                } else {
                    String[] inputSplit = inputLine.split("&");
                    String enteredUsername = inputSplit[0].split("=")[1];
                    String enteredPassword = inputSplit[1].split("=")[1];
                    
                    if (authenticator.isLoginValid(enteredUsername, enteredPassword)) {
                        isLoggedIn = true;
                        out.println("Login valid! Please enter a filename to retrieve.");
                    } else {
                        out.println("Login invalid, please try again.");
                    }
                }
            }
            
            socket.close();
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + socket.getPort() + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
