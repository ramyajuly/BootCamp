package com.trilogy;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;
    private double miles;
    private int uniqueId;

    public Car(){

    }
    public Car(String make,String model,int year,String color,double miles,int uniqueId){
        this.make = make;
        this.model =model;
        this.year=year;
        this.miles =miles;
        this.color = color;
        this.uniqueId= uniqueId;
    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getMiles() {
        return miles;
    }

    public void setMiles(double miles) {
        this.miles = miles;
    }

    public int getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(int uniqueId) {
        this.uniqueId = uniqueId;
    }

}
