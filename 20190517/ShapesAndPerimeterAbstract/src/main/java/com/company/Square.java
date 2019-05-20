package com.company;

import com.company.abstractapproach.Shape;

public class Square extends Shape {
    private double length;

    public Square(double length) {
        super("Square", "Blue");
        this.length = length;

    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double perimeter() {
        return 4 * getLength();
    }

    @Override
    public double area() {
        return getLength() * getLength();
    }
}
