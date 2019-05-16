package com.company;

/**
 * Program to calculate area and perimeter of Square, Circle and Triangle
 */
public class Main {
    public static void main(String[] args) {
        areaAndPerimeterSquare();
        areaAndPerimeterCircle();
        areaAndPerimeterTriangle();
    }

    public static void areaAndPerimeterSquare() {
        Square square = new Square(20);
        System.out.println("Area of Square: " + square.area());
        System.out.println("Perimeter of Square: " + square.perimeter());
    }

    public static void areaAndPerimeterCircle() {
        Circle circle = new Circle(5);
        System.out.println("---------------------------------------------");
        System.out.println("Area of Circle: " + circle.area());
        System.out.println("Perimeter of Circle: " + circle.perimeter());

    }

    public static void areaAndPerimeterTriangle() {
        Triangle triangle = new Triangle(4,5,6);
        System.out.println("---------------------------------------------");
        System.out.println("Area of triangle: " + triangle.area());
        System.out.println("Perimeter of triangle: " + triangle.perimeter());
    }
}
