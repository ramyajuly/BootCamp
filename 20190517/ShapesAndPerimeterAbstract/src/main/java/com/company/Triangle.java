package com.company;

import com.company.abstractapproach.Shape;

public class Triangle extends Shape {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        super("Traingle", "Green");
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
        double s = (getSideA() + getSideB() + getSideC()) / 2;
        s = Math.sqrt(s * (s - getSideA()) * (s - getSideB()) * (s - getSideC()));
        return s;
    }
}
