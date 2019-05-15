package com.trilogy;

public class CoffeeMaker {
    private String manufacturer;
    private String model;
    private int carafeSize;
    private int cupsLeft;
    private boolean powered;

    public CoffeeMaker(int carafeSize, String manufacturer, String model) {
        this.carafeSize = carafeSize;
        this.manufacturer = manufacturer;
        this.model = model;
        this.cupsLeft = 0;
        this.powered = false;
    }

    public void brew() {
        if (isPowered()) {
            this.cupsLeft = getCarafeSize();
        }
    }

    public void pourCoffee(int numCups) {
        if (getCupsLeft() > numCups) {
            this.cupsLeft = getCupsLeft() - numCups;
        } else {
            this.cupsLeft = 0;
        }
    }

    public void togglePower() {
        this.powered = !powered;
    }


    public boolean isPowered() {
        return powered;
    }

    public int getCarafeSize() {
        return carafeSize;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getCupsLeft() {
        return cupsLeft;
    }


}
