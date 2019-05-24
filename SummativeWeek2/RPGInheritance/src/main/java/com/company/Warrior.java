package com.company;

public class Warrior extends Character {

    private int shieldStrength = 100;

    public Warrior(String name) {
        setName(name);
        setStrength(75);
        setHealth(100);
        setStamina(100);
        setSpeed(50);
        setAttackPower(10);
    }

    public void decreaseShieldStrength() {
        System.out.println("Decreases shield strength of Warrior");
        shieldStrength--;
    }

}
