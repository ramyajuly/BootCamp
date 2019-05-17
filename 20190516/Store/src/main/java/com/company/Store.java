package com.company;

public class Store {
    private String name;
    private boolean open;

    private Chips chips;
    private SodaPop sodaPop;
    private Chocolate chocolate;

    public Store() {
        this.name = "myStore";
        this.open = true;
        chips = new Chips();
        sodaPop = new SodaPop();
        chocolate = new Chocolate();
    }

    public Store(String name, boolean open) {
        this.name = name;
        this.open = open;
        chips = new Chips();
        sodaPop = new SodaPop();
        chocolate = new Chocolate();
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

    public Chips getChips() {
        return chips;
    }

    public void setChips(Chips chips) {
        this.chips = chips;
    }

    public SodaPop getSodaPop() {
        return sodaPop;
    }

    public void setSodaPop(SodaPop sodaPop) {
        this.sodaPop = sodaPop;
    }

    public Chocolate getChocolate() {
        return chocolate;
    }

    public void setChocolate(Chocolate chocolate) {
        this.chocolate = chocolate;
    }

    public void printInventory() {
        System.out.println("Executing printInventory method of Store class");
    }

}
