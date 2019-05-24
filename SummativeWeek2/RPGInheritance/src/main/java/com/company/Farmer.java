package com.company;

public class Farmer extends Character {

    public Farmer(String name) {
        setName(name);
        setStrength(75);
        setHealth(100);
        setStamina(75);
        setSpeed(10);
        setAttackPower(1);
    }

    public void plow() {
        System.out.println("Farmer- Plow");
    }

    public void harvest() {
        System.out.println("Farmer -Harvest");
    }

}

