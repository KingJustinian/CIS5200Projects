package cis5200.project8;

import javax.swing.JFrame;

/**
 *
 * @author justin
 */
public class BouncingBallApp {
    
    public static int FRAME_SIZE = 600;
    
    public static void main(String[] args) {
       JFrame frame = new JFrame("Bouncing Ball"); 
       
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
              
       BouncingBallPanel ballPanel = new BouncingBallPanel();
       frame.add(ballPanel);
       frame.addMouseListener(ballPanel);
       
       frame.setSize(FRAME_SIZE, FRAME_SIZE);
       frame.setVisible(true);
    }
}
