package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Triangle extends TwoDimensionalShape {
    private double base;
    private double height;
    
    public Triangle(Color color, double x, double y, double base, double height) {
        super(color, x, y);
        this.base = base;
        this.height = height;
    }
    
    @Override
    public double getArea() {
        return 0.5 * base * height;
    }

    /**
     * @return the base
     */
    public double getBase() {
        return base;
    }

    /**
     * @param base the base to set
     */
    public void setBase(double base) {
        this.base = base;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return String.format("%s%nTriangle with base: %s, height: %s", 
                super.toString(), base, height);
    }
}
