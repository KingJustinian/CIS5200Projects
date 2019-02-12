package cis5200.project8;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.swing.JPanel;

/**
 *
 * @author justin
 */
public class BouncingBallPanel extends JPanel implements MouseListener {

    Ball[] balls;
    private int ballCount;
    
    ExecutorService executorService;
    
    public BouncingBallPanel() {
        balls = new Ball[20];
        executorService = Executors.newCachedThreadPool();
    }
    
    @Override
    public void mouseClicked(MouseEvent me) {
        if (ballCount < 20) {
            Ball ball = new Ball(this);
            balls[ballCount++] = ball;

            executorService.execute(ball);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        // Do nothing
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        // Do nothing
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        // Do nothing
    }

    @Override
    public void mouseExited(MouseEvent me) {
        // Do nothing
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            if (ball != null)
            {
                draw(ball, g);
            }
        }
    }
    
    private void draw(Ball ball, Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        // Assume x, y, and diameter are instance variables.
        Ellipse2D.Double circle = new Ellipse2D.Double(ball.getX(), ball.getY(), 
                ball.getDiameter(), ball.getDiameter());
        g2d.setPaint(ball.getColor());
        g2d.fill(circle);
    }
}
