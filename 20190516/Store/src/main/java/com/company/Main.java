package com.company;

public class Main {
    public static void main(String[] args) {
        Store myStore = new Store("myStore", true);
        System.out.println("-------------------------------------------------------------");
        myStore.printInventory();
        myStore.getChips().ingredients();
        myStore.getSodaPop().ingredients();
        myStore.getChocolate().ingredients();
        System.out.println("-------------------------------------------------------------");

        VendingMachine myVendingMachine = new VendingMachine(12.0);
        myVendingMachine.addCurrency();
        myVendingMachine.selectItem();
        myVendingMachine.getChips().ingredients();
        myVendingMachine.getSodaPop().ingredients();
        myVendingMachine.getChocolate().ingredients();
        myVendingMachine.getMints().ingredients();
        myVendingMachine.getGum().ingredients();
        myVendingMachine.getPopcorn().ingredients();
        System.out.println("-------------------------------------------------------------");

        Restaurant myRestaurant = new Restaurant("myRestaurant", true);
        myRestaurant.placeOrder();
        myRestaurant.getSodaPop().ingredients();
        System.out.println("-------------------------------------------------------------");
    }
}
