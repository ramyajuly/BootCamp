package com.company;

public class Main {
    public static void main(String[] args) {
        instantiationCar();
        instantiationSedan();
        instantitionAccord();
    }

    public static void instantiationCar() {
        Car car = new Car("2016", "Ford", 1000);
        System.out.println("Car details from CAR class: ");
        System.out.println("Car Model: " + car.getModel() + "\nCar make: " + car.getMake() +
                "\nMiles traveled by car: " + car.getMilesTraveled() + "\n");
        car.displayMilesTraveled();
        car.drive();
        System.out.println("-------------------------------------------------------------");
    }

    public static void instantiationSedan() {
        Sedan sedan = new Sedan(2, false);
        System.out.println("Car details from SEDAN class: ");
        sedan.setMake("2019-SEDAN");
        sedan.setModel("SEDAN");
        sedan.setMilesTraveled(2000);
        System.out.println("Car Model: " + sedan.getModel() + "\nSEDAN Car Make: " + sedan.getMake() +
                "\nMiles traveled by SEDAN car: " + sedan.getMilesTraveled() +
                "\nNumber of Doors in SEDAN car: " + sedan.getNumDoors() +
                "\nPowered windows in SEDAN car: " + sedan.isPoweredWindows());
        sedan.displayMilesTraveled();
        sedan.drive();
        System.out.println("-------------------------------------------------------------------------------");

    }

    public static void instantitionAccord() {
        Accord accord = new Accord("2001", new Engine(), new Transmission());
        System.out.println("Car details from ACCORD class: ");
        accord.setMake("2019-ACCORD");
        accord.setModel("ACCORD");
        accord.setMilesTraveled(3000);
        accord.setNumDoors(4);
        accord.setPoweredWindows(true);
        accord.getEngine().engineSpeed();
        accord.getTransmission().gearTransmissio();
        accord.displayMilesTraveled();
        accord.drive();
        System.out.println("Car Model: " + accord.getModel() + "\nACCORD Car Make: " + accord.getMake() +
                "\nMiles traveled by ACCORD car: " + accord.getMilesTraveled() +
                "\nNumber of Doors in ACCORD car: " + accord.getNumDoors() +
                "\nPowered windows in ACCORD car: " + accord.isPoweredWindows());
    }

}

