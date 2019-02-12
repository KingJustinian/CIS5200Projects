package cis5200.project8;

import java.awt.Color;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author justin
 */
public class Ball implements Runnable {
    BouncingBallPanel ballPanel;
    
    private double x;
    private double y;
    private double diameter = 40.0;
    private Color color;
    private int deltaX;
    private int deltaY;
    
    SecureRandom random = new SecureRandom();
    
    public Ball(BouncingBallPanel ballPanel) {
        this.ballPanel = ballPanel;
        
        x = generateRandomBallCoordinate();
        y = generateRandomBallCoordinate();
        
        color = new Color(random.nextFloat(), random.nextFloat(), random.nextFloat());
        
        // Randomize what direction the ball is going in, between -40 and 40
        deltaX = random.nextInt(80) - 40;
        deltaY = random.nextInt(80) - 40;
    }
    
    public double getX() {
        return x;
    }
    
    public double getY() {
        return y;
    }
    
    public double getDiameter() {
        return diameter;
    }
    
    public Color getColor() {
        return color;
    }
    
    @Override
    public void run() {
        while (true) {
            move();
            ballPanel.repaint();
            try {
                // Used deltaX/deltaY to make balls move different speeds instead
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }
    
    private double generateRandomBallCoordinate() {
        // Make sure ball fits within the frame coordinates fully
        double coordinate = random.nextInt(BouncingBallApp.FRAME_SIZE);
        coordinate = Math.min(BouncingBallApp.FRAME_SIZE - (diameter + 30), coordinate);
        
        return coordinate;
    }
    
    private void move() {
        x = x + deltaX;
        y = y + deltaY;
        
        if (x + diameter > BouncingBallApp.FRAME_SIZE) {
            x = BouncingBallApp.FRAME_SIZE - diameter;
            deltaX = deltaX * -1;
        } else if (x < 0) {
            x = 0;
            deltaX = deltaX * -1;
        }
        
        if (y + (diameter + 30) > BouncingBallApp.FRAME_SIZE) {
            y = BouncingBallApp.FRAME_SIZE - (diameter + 30);
            deltaY = deltaY * -1;
        } else if (y < 0) {
            y = 0;
            deltaY = deltaY * -1;
        }
    }
}
