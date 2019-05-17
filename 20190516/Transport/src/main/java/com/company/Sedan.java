package com.company;

public class Sedan extends Car {
    private int numDoors;
    private boolean poweredWindows;

    public Sedan() {

    }

    public Sedan(int numDoors, boolean poweredWindows) {
        this.numDoors = numDoors;
        this.poweredWindows = poweredWindows;
    }

    public int getNumDoors() {
        return numDoors;
    }

    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }

    public boolean isPoweredWindows() {
        return poweredWindows;
    }

    public void setPoweredWindows(boolean poweredWindows) {
        this.poweredWindows = poweredWindows;
    }


    @Override
    public void drive() {
        System.out.println("Driving a SEDAN Car");
    }

    @Override
    public void displayMilesTraveled() {
        System.out.println("Miles traveled, displayed in SEDAN CAR");
    }
}
