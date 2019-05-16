package com.company;

import com.company.interfaces.Shape;

/**
 * Formula:
 * area = pie * r*r
 * perimeter C=2πr
 */
public class Circle implements Shape {
    private double radius;
    private double pie;

    public Circle(double radius) {
        this.radius = radius;
        this.pie = Math.PI;
    }

    public double getPie() {
        return pie;
    }

    public void setPie(double pie) {
        this.pie = pie;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * getPie() * getRadius();
    }

    @Override
    public double area() {
        return (getPie() * (getRadius() * getRadius()));
    }
}
