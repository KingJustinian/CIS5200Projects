package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public abstract class Shape {
    private Color color;

    public Shape(Color color)
    {
        this.color = color;
    }
    
    /**
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(Color color) {
        this.color = color;
    }
    
    @Override
    public String toString() {
        return String.format("Shape with color: %s", color);
    }
}
