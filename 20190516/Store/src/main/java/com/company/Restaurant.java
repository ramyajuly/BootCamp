package com.company;

public class Restaurant {
    private String name;
    private boolean open;

    private SodaPop sodaPop;

    public Restaurant() {
        this.name = "myRestaurant";
        this.open = true;

        sodaPop = new SodaPop();
    }

    public Restaurant(String name, boolean open) {
        this.name = name;
        this.open = open;

        sodaPop = new SodaPop();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public void placeOrder() {
        System.out.println("Executing placeOrder method of Restaurant class");
    }
}
