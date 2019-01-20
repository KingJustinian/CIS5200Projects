package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Sphere extends ThreeDimensionalShape {
    private double x;
    private double y;
    private double z;
    private double radius;
    
    public Sphere(Color color, double x, double y, double z, double radius) {
        super(color, x, y, z);
        this.radius = radius;
    }
    
    @Override
    public double getArea() {
        return 4.0 * Math.PI * Math.pow(radius, 2.0);
    }
    
    @Override
    public double getVolume()
    {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3.0);
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
        return String.format("%s%nSphere with radius: %s", super.toString(), radius);
    }
}
