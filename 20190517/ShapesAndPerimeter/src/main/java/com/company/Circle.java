package com.company;

import com.company.concreteapproach.Shape;

public class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        super("Circle", "White");
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (getRadius() * getRadius());
    }

    @Override
    public double perimeter() {
        return (2 * Math.PI * getRadius());
    }
}
