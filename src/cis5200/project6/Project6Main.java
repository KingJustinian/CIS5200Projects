package cis5200.project6;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * CIS5200-W01
 * Project 6, Exercise 26.9, Calculator GUI
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project6Main {
    public static void main(String[] args) {
        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.setMinimumSize(new Dimension(300, 300));
        calculatorFrame.setPreferredSize(new Dimension(300, 300));
        calculatorFrame.setVisible(true);
    }
}
