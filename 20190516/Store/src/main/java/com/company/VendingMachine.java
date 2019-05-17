package com.company;

public class VendingMachine {
    private double currentBalance;

    private Chips chips;
    private SodaPop sodaPop;
    private Chocolate chocolate;
    private Mints mints;
    private Gum gum;
    private Popcorn popcorn;

    public VendingMachine() {
        this.currentBalance = 0.0;

        chips = new Chips();
        sodaPop = new SodaPop();
        chocolate = new Chocolate();
        mints = new Mints();
        gum = new Gum();
        popcorn = new Popcorn();
    }

    public VendingMachine(double currentBalance) {
        this.currentBalance = currentBalance;

        chips = new Chips();
        sodaPop = new SodaPop();
        chocolate = new Chocolate();
        mints = new Mints();
        gum = new Gum();
        popcorn = new Popcorn();
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
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

    public Mints getMints() {
        return mints;
    }

    public void setMints(Mints mints) {
        this.mints = mints;
    }

    public Gum getGum() {
        return gum;
    }

    public void setGum(Gum gum) {
        this.gum = gum;
    }

    public Popcorn getPopcorn() {
        return popcorn;
    }

    public void setPopcorn(Popcorn popcorn) {
        this.popcorn = popcorn;
    }

    public void addCurrency() {
        System.out.println("Executing addCurrency method of VendingMachine class");
    }

    public void selectItem() {
        System.out.println("Executing selectItem method of VendingMachine class");
    }
}
