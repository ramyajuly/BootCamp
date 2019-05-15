package com.trilogy;

public class Microwave {
    private String manufacturer;
    private String model;
    private int secondsLeft;
    private String time;
    private boolean running;

    public Microwave(String manufacturer, String model) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.secondsLeft = 0;
        this.time = "12:00";
        this.running = false;
    }

    public void start(int secondsLeft) {
        this.secondsLeft = secondsLeft;
        this.running = true;
    }

    public void stop() {
        this.running = false;
    }

    public void clear() {
        this.secondsLeft = 0;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    public void setSecondsLeft(int secondsLeft) {
        this.secondsLeft = secondsLeft;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isRunning() {
        return running;
    }

}
