package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public abstract class TwoDimensionalShape extends Shape {
    private double x;
    private double y;
    
    public TwoDimensionalShape(Color color, double x, double y) {
        super(color);
        this.x = x;
        this.y = y;
    }
    
    public abstract double getArea();

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }
    
    @Override
    public String toString() {
        return String.format("%s%nTwoDimensionalShape with x: %s, y: %s", super.toString(), x, y);
    }
}
