package com.trilogy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Program for Car inventory to add, delete, search and list all cars
 */
public class MainMenu {
    private static boolean exit = false;
    private static int uniqueId = 4;

    public static void main(String[] args) {
        String userInputString = "";
        int userInputInt;
        double userInputdbl;
        int userInput;
        Car car = new Car();
        UserInventoryActions userInventoryActions = new UserInventoryActions();
        mainMenu();
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        cars = userInventoryActions.carDatabase();
        do {
            try {
                userInput = Integer.parseInt(scanner.nextLine());
                if (userInput == 1) {
                    System.out.println("Please enter MAKE for the car:");
                    userInputString = scanner.nextLine();
                    car.setMake(userInputString);
                    System.out.println("Please enter MODEL for the car:");
                    userInputString = scanner.nextLine();
                    car.setModel(userInputString);
                    System.out.println("Please enter YEAR for the car:");
                    userInputInt = Integer.parseInt(scanner.nextLine());
                    car.setYear(userInputInt);
                    System.out.println("Please enter COLOR for the car:");
                    userInputString = scanner.nextLine();
                    car.setColor(userInputString);
                    System.out.println("Please enter MILES for the car:");
                    userInputdbl = Double.parseDouble(scanner.nextLine());
                    car.setMiles(userInputdbl);
                    car.setUniqueId(uniqueId);
                    cars = userInventoryActions.addCar(cars, car);
                    uniqueId++;
                    userInput = 0;
                    System.out.println("Car added successfully");
                    simpleprompt();
                } else if (userInput == 2) {
                    userInventoryActions.listAllCars(cars);
                    System.out.println("Please enter CarID from the above list to delete a car record from inventory?");
                    userInput = Integer.parseInt(scanner.nextLine());
                    cars = userInventoryActions.deleteCar(cars, userInput);
                    System.out.println("Car deleted successfully");
                    simpleprompt();
                    userInput = 0;
                } else if (userInput == 3) {
                    System.out.println("List of all cars in inventory!");
                    userInventoryActions.listAllCars(cars);
                    simpleprompt();
                    userInput = 0;
                } else if (userInput == 4) {

                    System.out.println("Please enter number(1, 2,3,4 or 5) to search car: MAKE 1 | MODEL 2 | COLOR 3| YEAR 4| MILES 5 | EXIT 6");
                    userInput = Integer.parseInt(scanner.nextLine());

                    if (userInput == 1) {
                        System.out.println("Please enter Make:");
                        userInputString = scanner.nextLine();
                    }
                    if (userInput == 2) {
                        System.out.println("Please enter Model:");
                        userInputString = scanner.nextLine();
                    }
                    if (userInput == 3) {
                        System.out.println("Please enter Color:");
                        userInputString = scanner.nextLine();
                    }
                    if (userInput == 4) {
                        System.out.println("Please enter Year:");
                        userInputString = scanner.nextLine();
                    }
                    if (userInput == 5) {
                        System.out.println("Please enter Miles:");
                        userInputString = scanner.nextLine();
                    }
                    userInventoryActions.listAllCars(userInventoryActions.searchCars(cars, userInput, userInputString));
                    userInput = 0;
                    simpleprompt();

                } else if (userInput == 5) {
                    confirm();
                    userInputString = scanner.nextLine();
                    if (userInputString.equalsIgnoreCase("Y")) {
                        exit = true;
                    } else {
                        simpleprompt();
                    }
                }
                else{
                    System.out.println("Please select numbers from menu:");
                    simpleprompt();
                }
            } catch (Exception ex) {
                System.out.println("Input is not in correct format!");
                simpleprompt();
                userInput = 0;
            }
        } while (!exit);
    }

    public static void mainMenu() {
        System.out.println("WELCOME TO CAR INVENTORY");
        System.out.println("To ADD a car to Inventory, Please enter 1");
        System.out.println("To DELETE a car from Inventory, Please enter 2");
        System.out.println("To LIST all car, Please enter 3");
        System.out.println("To search a car, Please enter 4");
        System.out.println("To exit application, Please enter 5");
    }

    public static void simpleprompt() {
        System.out.println("Select number(1, 2, 3,4 or 5) to continue! ADD : 1 | DELETE: 2 | LIST ALL : 3 | SEARCH : 4| EXIT: 5");
    }

    public static void confirm() {
        System.out.println("Please enter Y to exit and N to continue");
    }
}
