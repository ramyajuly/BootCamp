package com.company;

import java.util.ArrayList;
import java.util.List;

/** ClassDesign
 * Program to add values to factoryIcecream and PointofsaleIcecream classes and print the data
 */
public class IceCream {
    public static void main(String[] args) {
        try {
            printFactoryIcecream(factoryIceCream());
            printPointOfSaleIceCream(pointOfSaleIceCream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     *To add data to Factory Icecream
     * @return
     */
    public static List<FactoryIceCream> factoryIceCream() {
        List<Ingredients> lstIngredients = new ArrayList<>();
        lstIngredients.add(new Ingredients("cream", 50, "OZ"));
        lstIngredients.add(new Ingredients("Ice", 100, "OZ"));
        List<FactoryIceCream> lstFactoyIceCream = new ArrayList<>();
        lstFactoyIceCream.add(new FactoryIceCream("Tasty icecream", 56, lstIngredients));
        lstFactoyIceCream.add(new FactoryIceCream("Soft IceCream", 70, lstIngredients));
        return lstFactoyIceCream;
    }

    /**
     * To print Factory icecream details
     * @param lstFactoyIceCream
     */
    public static void printFactoryIcecream(List<FactoryIceCream> lstFactoyIceCream) {
        System.out.println("Factory type Ice cream");
        lstFactoyIceCream.stream().forEach(
                cream -> {
                    System.out.println("----------------------------------------");
                    System.out.println("Ice cream type: " + cream.getType());
                    System.out.println("Ice cream size: " + cream.getSize());
                    cream.getIngredients().stream().forEach(ing -> {
                        System.out.println("Ingredients name: " + ing.getName());
                        System.out.println("Ingredients quantity: " + ing.getQuantity());
                        System.out.println("Ingredients unit: " + ing.getUnit());
                    });
                });
    }

    /**
     * To add data to Point Of sale Icecream
     * @return
     */
    public static List<PointOfSaleIceCream> pointOfSaleIceCream(){
        List<PointOfSaleIceCream> lstPointOfSaleICeCream = new ArrayList<>();
        lstPointOfSaleICeCream.add(new PointOfSaleIceCream(1001,22556,65,
                45.65,"Strawberry",650,"contains peanuts"));
        lstPointOfSaleICeCream.add(new PointOfSaleIceCream(1002,22557,66,
                47.65,"Vanilla",750,"contains cashews"));
        return lstPointOfSaleICeCream;
    }

    /**
     *To print Point of sale ice cream details
     * @param lstPointOfsaleIceCream
     */
    public static void printPointOfSaleIceCream(List<PointOfSaleIceCream> lstPointOfsaleIceCream){
        System.out.println("------------------------------------------");
        System.out.println("Point of sale Ice cream:");
        lstPointOfsaleIceCream.stream().forEach(
                cream -> {
                    System.out.println("------------------------------------------");
                    System.out.println("Ice cream product ID: " + cream.getProductId());
                    System.out.println("Ice cream barcode: " + cream.getBarCode());
                    System.out.println("Ice cream size: " + cream.getSize());
                    System.out.println("Ice cream price: " + cream.getAmount());
                    System.out.println("Ice cream flavor: " + cream.getFlavor());
                    System.out.println("Ice cream calories: " + cream.getCalories());
                    System.out.println("Ice cream Allergen Info: " + cream.getAllergenInfo());
                });

    }

}
