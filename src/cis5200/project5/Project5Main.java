package cis5200.project5;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * CIS5200-W01
 * Project 5, Exercise 27.11 5x5 Grid
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project5Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Project 5 5x5 Rectangles Justin Burden");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Project5JPanel gridJPanel = new Project5JPanel();
        frame.setBackground(Color.WHITE);
        frame.add(gridJPanel);
        frame.setSize(600, 600);
        frame.setVisible(true);
    }
}
