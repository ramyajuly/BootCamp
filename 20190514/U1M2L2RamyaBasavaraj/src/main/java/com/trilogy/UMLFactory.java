package com.trilogy;

/**
 * Program to multiple instances, and to modify properties and call methods on each.
 */
public class UMLFactory {
    public static void main(String[] args) {
        instantiateRadio();
        instantiateTV();
        instantiateMicrowave();
        instantiateCoffeeMaker();
        instantiateCar();
        instantiateComputerMouse();
    }

    public static void instantiateRadio() {
        System.out.println("First time instantiating Radio Class: ");
        Radio newRadio = new Radio("ABC", "BrandNew", 2);
        newRadio.setStation("99.9");
        newRadio.setPowered(true);
        newRadio.togglePower(newRadio.isPowered());
        System.out.println("Manufacturer:" + newRadio.getManufacturer() + " , Station:" + newRadio.getStation() +
                " , Model:" + newRadio.getModel() + " , Speakers:" + newRadio.getNumSpeaker());
        System.out.println("Second time instantiating Radio Class: ");
        Radio oldRadio = new Radio("XYZ", "Old", 1);
        oldRadio.setStation("101.1");
        oldRadio.setPowered(false);
        oldRadio.togglePower(oldRadio.isPowered());
        System.out.println("Manufacturer:" + oldRadio.getManufacturer() + " , Station:" + oldRadio.getStation() +
                " , Model:" + oldRadio.getModel() + " , Speakers:" + oldRadio.getNumSpeaker());

    }

    public static void instantiateTV() {
        System.out.println("------------------------------------------------ ");
        System.out.println("First time instantiating TV Class: ");
        TV newTV = new TV("ABC", "Smart", 5);
        newTV.setChannel("6");
        newTV.setPowered(true);
        newTV.togglePower(newTV.isPowered());
        System.out.println("Manufacturer:" + newTV.getManufacturer() + " , Model:" + newTV.getModel() +
                " , ScreeenSize:" + newTV.getScreenSize() + " , Channel: " + newTV.getChannel());
        System.out.println("Second time instantiating TV Class: ");
        TV oldTV = new TV("XYZ", "Manual", 10);
        oldTV.setChannel("10");
        oldTV.setPowered(false);
        oldTV.togglePower(oldTV.isPowered());
        System.out.println("Manufacturer:" + oldTV.getManufacturer() + " , Model:" + oldTV.getModel() +
                " , ScreeenSize:" + oldTV.getScreenSize() + " , Channel: " + oldTV.getChannel());

    }

    public static void instantiateMicrowave() {
        System.out.println("------------------------------------------------ ");
        System.out.println("First time instantiating Microwave Class: ");
        Microwave newMicrowave = new Microwave("Whirlpool", "Counter Top");
        newMicrowave.setSecondsLeft(1);
        newMicrowave.setTime("03:00");
        newMicrowave.start(newMicrowave.getSecondsLeft());
        System.out.println("Is Microwave ON:" + newMicrowave.isRunning());
        newMicrowave.stop();
        System.out.println("Is Microwave OFF::" + newMicrowave.isRunning());
        newMicrowave.clear();
        System.out.println("Seconds Left: " + newMicrowave.getSecondsLeft());
        System.out.println("Manufacturer:" + newMicrowave.getManufacturer() + " ,  Model:" + newMicrowave.getModel());
        System.out.println("Second time instantiating Microwave Class: ");
        Microwave oldMicrowave = new Microwave("Panasonic", "Over the counter");
        oldMicrowave.setSecondsLeft(1);
        oldMicrowave.setTime("03:00");
        oldMicrowave.start(oldMicrowave.getSecondsLeft());
        System.out.println("Is Microwave ON:" + oldMicrowave.isRunning());
        oldMicrowave.stop();
        System.out.println("Is Microwave OFF::" + oldMicrowave.isRunning());
        oldMicrowave.clear();
        System.out.println("Seconds Left: " + oldMicrowave.getSecondsLeft());
        System.out.println("Manufacturer:" + oldMicrowave.getManufacturer() + " ,  Model:" + oldMicrowave.getModel());

    }

    public static void instantiateCoffeeMaker() {
        System.out.println("------------------------------------------------ ");
        System.out.println("First time instantiating Coffee Maker Class: ");
        CoffeeMaker newCoffeeMaker = new CoffeeMaker(1,"Mr.Coffee","Classic");
        newCoffeeMaker.brew();
        newCoffeeMaker.pourCoffee(6);
        newCoffeeMaker.togglePower();
        System.out.println("CarafeSize:" + newCoffeeMaker.getCarafeSize()+ " , " +
                "Manufacturer:" + newCoffeeMaker.getManufacturer() +
                " ,  Model:" + newCoffeeMaker.getModel() + ", Cups Left:" + newCoffeeMaker.getCupsLeft());
        System.out.println("Second time instantiating Coffee Maker Class: ");
        CoffeeMaker oldCoffeeMaker = new CoffeeMaker(2,"Cuisinart","Advanced Brew");
        oldCoffeeMaker.brew();
        oldCoffeeMaker.pourCoffee(6);
        oldCoffeeMaker.togglePower();
        System.out.println("CarafeSize:" + oldCoffeeMaker.getCarafeSize()+ " , " +
                "Manufacturer:" + oldCoffeeMaker.getManufacturer() +
                " ,  Model:" + oldCoffeeMaker.getModel() + ", Cups Left:" + oldCoffeeMaker.getCupsLeft());


    }

    public static void instantiateCar() {
        System.out.println("------------------------------------------------ ");
        System.out.println("First time instantiating Car Class: ");
        Car newCar= new Car("ABC","Wagon","ManualStart","White",
                "Wagon-engine","Wagon-transmission",4,10.10);
        newCar.honk();
        newCar.drive(1000);
        System.out.println("Car Make: " + newCar.getMake()+ " , model:" + newCar.getModel() + " , Type:"
        + newCar.getType()+ " , color: " + newCar.getColor()+ " , Engine: " + newCar.getEngine() + " , Transmission:"
        + newCar.getTransmission() + " , Number of Doors:" + newCar.getNumDoors() +
                " , mpg:" + newCar.getMpg()+" , Miles Driven:" + newCar.getMilesDriven());
        System.out.println("Second time instantiating Car Class: ");
        Car oldCar= new Car("XYZ","Nissan","AutoStart","Purple",
                "Nissan-engine","Nissan-transmission",2,12.10);
        oldCar.honk();
        oldCar.drive(3000);
        System.out.println("Car Make: " + oldCar.getMake()+ " , model:" + oldCar.getModel() + " , Type:"
                + oldCar.getType()+ " , color: " + oldCar.getColor()+ " , Engine: " + oldCar.getEngine() + " , Transmission:"
                + oldCar.getTransmission() + " , Number of Doors:" + oldCar.getNumDoors() +
                " , mpg:" + oldCar.getMpg()+" , Miles Driven:" + oldCar.getMilesDriven());

    }

    public static void instantiateComputerMouse() {
        System.out.println("------------------------------------------------ ");
        System.out.println("First time instantiating ComputerMouse Class: ");
        ComputerMouse newComputerMouse = new ComputerMouse("HP","New");
        newComputerMouse.click();
        newComputerMouse.move(1,5);
        int[] mousePosition = newComputerMouse.getCurrentPosition();

        int[] lastPosition = newComputerMouse.getLastClickedLocation();
        System.out.println("Manufacture:" + newComputerMouse.getManufacturer()+ " , Model:" +newComputerMouse.getModel()+
                " , Get Position: (" +  mousePosition[0] + ","+ mousePosition[1] +
                ") , Last Clicked position:(" +  lastPosition[0] + ","+ lastPosition[1] +
                ")");
        System.out.println("Second time instantiating ComputerMouse Class: ");
        ComputerMouse oldComputerMouse = new ComputerMouse("Lenova","Old");
        newComputerMouse.click();
        newComputerMouse.move(6,12);
        int[] mousePosition1 = newComputerMouse.getCurrentPosition();
        int[] lastPosition1 = newComputerMouse.getLastClickedLocation();
        System.out.println("Manufacture:" + newComputerMouse.getManufacturer()+ " , Model:" +newComputerMouse.getModel()+
                " , Get Position: (" +  mousePosition1[0] + ","+ mousePosition1[1] +
                ") , Last Clicked position:(" +  lastPosition1[0] + ","+ lastPosition1[1] +
                ")");




    }
}
