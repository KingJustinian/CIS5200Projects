package cis5200.project7;

import java.io.IOException;

public class ExceptionHandlingDb {
    
    public static void main(String[] args) {
        try {
            terribleMethod();
            // A compiler error is generated if the IOException is not caught
        } catch (IOException ex) {
            // Catch the exception so it doesn't propogate further
            System.err.println(ex);
        }
    }
    
    public static void terribleMethod() throws IOException {
        throw new IOException();
    }
}
