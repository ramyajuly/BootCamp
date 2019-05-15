package com.trilogy;

public class ComputerMouse {
    private String manufacturer;
    private String model;
    private int xPosition;
    private int yPosition;
    private int[] lastClickedLocation;

    public ComputerMouse(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.xPosition = 0;
        this.yPosition = 0;
        this.lastClickedLocation = new int[]{0, 0};
    }

    public void move(int deltaX, int deltaY) {
        this.xPosition += deltaX;
        this.yPosition += deltaY;
    }

    public void click() {
        this.lastClickedLocation[0] = xPosition;
        this.lastClickedLocation[1] = yPosition;
    }

    public int[] getCurrentPosition() {
        return new int[]{xPosition, yPosition};
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int[] getLastClickedLocation() {
        return lastClickedLocation;
    }

}
