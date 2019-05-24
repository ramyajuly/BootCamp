package com.company;

/**
 * Program on Inheritance design
 */
public class RPGInheritance {
    public static void main(String[] args) {
        System.out.println("=================FARMER==================================");
        Farmer farmer = new Farmer("Farmer CBZ");
        farmer.run();
        farmer.plow();
        farmer.harvest();
        farmer.attack();
        farmer.heal();
        farmer.decreaseHealth();
        farmer.increaseStamina();
        farmer.decreaseStamina();
        System.out.println("====================CONSTABLE===============================");
        Constable constable = new Constable("CONSTABLE XYZ", "ABC");
        constable.run();
        constable.attack();
        constable.arrest();
        constable.heal();
        constable.decreaseHealth();
        constable.increaseStamina();
        constable.decreaseStamina();
        System.out.println("=======================WARRIOR============================");
        Warrior warrior = new Warrior("Warrior Hercules");
        warrior.run();
        warrior.attack();
        warrior.heal();
        warrior.decreaseHealth();
        warrior.increaseStamina();
        warrior.decreaseStamina();
        warrior.decreaseShieldStrength();
    }
}
