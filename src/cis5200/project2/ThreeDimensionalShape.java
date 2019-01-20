package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public abstract class ThreeDimensionalShape extends Shape {
    private double x;
    private double y;
    private double z;
    
    public ThreeDimensionalShape(Color color, double x, double y, double z) {
        super(color);
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public abstract double getArea();
    
    public abstract double getVolume();

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

    /**
     * @return the z
     */
    public double getZ() {
        return z;
    }

    /**
     * @param z the z to set
     */
    public void setZ(double z) {
        this.z = z;
    }
    
    @Override
    public String toString() {
        return String.format("%s%nThreeDimensionalShape with x: %s, y: %s, z: %s", super.toString(), x, y, z);
    }
}
