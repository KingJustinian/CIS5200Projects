package cis5200.project2;

import java.awt.Color;

/**
 * CIS5200-W01
 * Project 2 , Problem 10.14 pg. 453
 * Justin Burden
 *
 * @author Justin Burden
 */
public class Project2Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle(Color.BLUE, 7.5, 6.0, 4.0);
        shapes[1] = new Square(Color.ORANGE, 3.3, 5.6, 5.0);
        shapes[2] = new Triangle(Color.PINK, 2.4, 1.3, 5.0, 3.0);
        shapes[3] = new Sphere(Color.GREEN, 8.7, 2.1, 3.9, 6.0);
        shapes[4] = new Cube(Color.RED, 1.7, 6.4, 4.2, 4.0);
        shapes[5] = new Tetrahedron(Color.YELLOW, 4.6, 5.2, 3.7, 5.0);
        
        for (Shape shape: shapes) {
            System.out.printf("Object class: %s%n", shape.getClass().getName());
            System.out.println(shape);
            
            if (shape instanceof TwoDimensionalShape) {
                TwoDimensionalShape twoDimShape = (TwoDimensionalShape) shape;
                System.out.printf("Area: %s%n", twoDimShape.getArea());
            } else if (shape instanceof ThreeDimensionalShape) {
                ThreeDimensionalShape threeDimShape = (ThreeDimensionalShape) shape;
                System.out.printf("Area: %s%n", threeDimShape.getArea());
                System.out.printf("Volume: %s%n", threeDimShape.getVolume());
            }
            
            System.out.println();
        }
    }
}
