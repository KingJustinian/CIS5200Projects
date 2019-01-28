package cis5200.project5;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * CIS5200-W01
 * Project 5, Exercise 27.11 5x5 Grid
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project5JPanel extends JPanel {
    
    private static final int START_SPACING = 50;
    private static final int SQUARE_WIDTH = 100;
    private static final int NUM_SQUARES = 5
;    private static final int END_SPACING = START_SPACING + NUM_SQUARES * SQUARE_WIDTH;
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.drawLine(START_SPACING, START_SPACING, END_SPACING, START_SPACING);
        g.drawLine(END_SPACING, START_SPACING, END_SPACING, END_SPACING);
        g.drawLine(END_SPACING, END_SPACING, START_SPACING, END_SPACING);
        g.drawLine(START_SPACING, END_SPACING, START_SPACING, START_SPACING);
        
        for (int i=1; i < NUM_SQUARES; i++) {
            final int gridLineCoordinate = START_SPACING + SQUARE_WIDTH * i;
            // Vertical line
            g.drawLine(gridLineCoordinate, START_SPACING, gridLineCoordinate, END_SPACING);
            
            // Horizontal line
            g.drawLine(START_SPACING, gridLineCoordinate, END_SPACING, gridLineCoordinate);
        }
    }
}
