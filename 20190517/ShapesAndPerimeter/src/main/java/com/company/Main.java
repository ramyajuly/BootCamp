package com.company;

import com.company.concreteapproach.Shape;

/**
 * Concrete Class Implementation
 * program to calculate area and perimeter of different shapes.
 */

public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle(12.5);
        System.out.println("Geometrical Shape: " + circle.getName());
        System.out.println("Color of shape: " + circle.getColor());
        System.out.format("Area of Circle: %.2f", circle.area());
        System.out.format("\nPerimeter of Circle: %.2f", circle.perimeter());
        System.out.println("\n----------------------------------------------");
        Shape square = new Square(6.5);
        System.out.println("Geometrical Shape: " + square.getName());
        System.out.println("Color of shape: " + square.getColor());
        System.out.format("Area of a Square: %.2f", square.area());
        System.out.format("\nPerimeter of a Square: %.2f", square.perimeter());
        System.out.println("\n----------------------------------------------");
        Shape triangle = new Triangle(4, 5, 6);
        System.out.println("Geometrical Shape: " + triangle.getName());
        System.out.println("Color of shape: " + triangle.getColor());
        System.out.format("Area of a triangle: %.2f", triangle.area());
        System.out.format("\nPerimeter of a triangle: %.2f", triangle.perimeter());
    }
}
