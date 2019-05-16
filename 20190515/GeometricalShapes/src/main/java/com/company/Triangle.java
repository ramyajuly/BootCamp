package com.company;

import com.company.interfaces.Shape;

/**Triangle:
 * Formula:
 * perimeter = a+b+c;
 * semi perimeter: s = a+b+c/2
 * area= sqrt{s(s-a)(s-b)(s-c)},
 */
public class Triangle implements Shape {

    private double sideA;
    private double sideB;
    private double sideC;


    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }


    public double getSideA() {
        return sideA;
    }

    public void setSideA(double sideA) {
        this.sideA = sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public void setSideB(double sideB) {
        this.sideB = sideB;
    }

    public double getSideC() {
        return sideC;
    }

    public void setSideC(double sideC) {
        this.sideC = sideC;
    }


    @Override
    public double perimeter() {
        return getSideA() + getSideB() + getSideC();
    }

    @Override
    public double area() {
        double s = perimeter() / 2;
        s = Math.sqrt(s * (s - getSideA()) * (s - getSideB()) * (s - getSideC()));
        return s;
    }


}
