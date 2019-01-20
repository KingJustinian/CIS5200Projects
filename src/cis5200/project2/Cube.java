package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Cube extends ThreeDimensionalShape {
    private double x;
    private double y;
    private double z;
    private double side;
    
    public Cube(Color color, double x, double y, double z, double side) {
        super(color, x, y, z);
        this.side = side;
    }
    
    @Override
    public double getArea() {
        return 6.0 * Math.pow(side, 2.0);
    }
    
    @Override
    public double getVolume()
    {
        return Math.pow(side, 3.0);
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
        return String.format("%s%nCube with side: %s", super.toString(), side);
    }
}
