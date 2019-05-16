package com.company;

import com.company.interfaces.Shape;
/**
 * Square:
 * Formula:
 * //area = a*a
 * //perimeter =4a
 */
public class Square implements Shape {
    private double length;
    public Square(double length) {
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
