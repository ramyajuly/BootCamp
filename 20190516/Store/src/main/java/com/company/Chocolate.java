package com.company;

public class Chocolate {
    private int size;
    private double price;

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void ingredients() {
        System.out.println("Executing ingredients method of Chocolate class");
    }

}
