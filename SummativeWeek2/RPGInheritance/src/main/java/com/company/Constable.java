package com.company;

public class Constable extends Character {
    private String jurisdiction;

    public Constable(String name, String jurisdiction) {
        this.jurisdiction = jurisdiction;
        setName(name);
        setStrength(60);
        setHealth(100);
        setStamina(60);
        setSpeed(20);
        setAttackPower(5);
    }

    public String getJurisdiction() {
        return jurisdiction;
    }

    public void setJurisdiction(String jurisdiction) {
        this.jurisdiction = jurisdiction;
    }

    public void arrest() {
        System.out.println("Constable: Arrest");
    }

}
