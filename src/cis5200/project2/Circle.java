package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Circle extends TwoDimensionalShape {
    private double radius;
    
    public Circle(Color color, double x, double y, double radius) {
        super(color, x, y);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2.0);
    }

    /**
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }

    /**
     * @param radius the radius to set
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    @Override
    public String toString() {
        return String.format("%s%nCircle with radius: %s", super.toString(), radius);
    }
}
