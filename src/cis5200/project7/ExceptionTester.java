package cis5200.project7;

/**
 * CIS5200-W01
 * Project 7, Exercise 11.16
 * Justin Burden
 *
 * @author Justin Burden
 */
public class ExceptionTester {
    public static void main(String[] args) {
        ExceptionA exceptionA = new ExceptionA();
        ExceptionB exceptionB = new ExceptionB();
        ExceptionC exceptionC = new ExceptionC();
        
        try {
            throw exceptionA;
        } catch (ExceptionA ex) {
            System.out.println(ex);
        }
        
        try {
            throw exceptionB;
        } catch (ExceptionA ex) {
            System.out.println(ex);
        }
        
        try {
            throw exceptionC;
        } catch (ExceptionA ex) {
            System.out.println(ex);
        }
        
        System.out.println("Program reached the end");
    }
}
