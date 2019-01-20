package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Square extends TwoDimensionalShape {
    private double side;
    
    public Square(Color color, double x, double y, double side) {
        super(color, x, y);
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return Math.pow(side, 2.0);
    }

    /**
     * @return the side
     */
    public double getSide() {
        return side;
    }

    /**
     * @param side the side to set
     */
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    public String toString() {
        return String.format("%s%nSquare with side: %s", super.toString(), side);
    }
}
