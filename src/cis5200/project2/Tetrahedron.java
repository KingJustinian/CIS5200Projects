package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Tetrahedron extends ThreeDimensionalShape {
    private double x;
    private double y;
    private double z;
    private double edgeLength;
    
    public Tetrahedron(Color color, double x, double y, double z, double edgeLength) {
        super(color, x, y, z);
        this.edgeLength = edgeLength;
    }
    
    @Override
    public double getArea() {
        return Math.sqrt(3.0) * Math.pow(edgeLength, 2.0);
    }
    
    @Override
    public double getVolume()
    {
        return (1.0 / 3.0) * ((Math.sqrt(3.0) * Math.pow(edgeLength, 2.0)) / 4.0) 
                * (Math.sqrt(2.0 / 3.0) * edgeLength);
    }

    /**
     * @return the edgeLength
     */
    public double getEdgeLength() {
        return edgeLength;
    }

    /**
     * @param edgeLength the edgeLength to set
     */
    public void setEdgeLength(double edgeLength) {
        this.edgeLength = edgeLength;
    }
    
    @Override
    public String toString() {
        return String.format("%s%nTetrahedron with edgeLength: %s", super.toString(), edgeLength);
    }
}
