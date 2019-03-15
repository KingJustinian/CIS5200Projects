package cis5200.project9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * CIS5200-W01
 * Project 9
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project9AuthenticationProtocol {
    protected final static String AUTHENTICATION_FILENAME = "authentication.txt";
    
    public boolean isLoginValid(String username, String password) {
        
        boolean isLoginValid = false;

        try (Stream<String> stream = Files.lines(Paths.get(AUTHENTICATION_FILENAME))) {

            isLoginValid = stream.anyMatch(loginStr -> 
                {   String storedUsername = loginStr.split("=")[0]; 
                    String storedPassword = loginStr.split("=")[1]; 
                    return username.equals(storedUsername) 
                            && password.equals(storedPassword);
                });
        } catch (NoSuchFileException e) {
            System.err.println("An error occurred during authentication, make sure authentication.txt "
                    + "exists in the current working directory: " + System.getProperty("user.dir"));
            System.err.println(e.getMessage());
            e.printStackTrace();
        }catch (IOException e) {
            System.err.println("An error occurred during authentication.");
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
            
        return isLoginValid;
    }
}
