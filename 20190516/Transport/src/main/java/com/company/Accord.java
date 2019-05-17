package com.company;

public class Accord extends Sedan {
   private String year;
   private  Engine engine;
   private Transmission transmission;

   public Accord(String year,Engine engine,Transmission transmission){
      this.year = year;
      this.engine= engine;
      this.transmission=transmission;

   }

   public String getYear() {
      return year;
   }

   public void setYear(String year) {
      this.year = year;
   }

   public Engine getEngine() {
      return engine;
   }

   public void setEngine(Engine engine) {
      this.engine = engine;
   }

   public Transmission getTransmission() {
      return transmission;
   }

   public void setTransmission(Transmission transmission) {
      this.transmission = transmission;
   }

   @Override
   public void drive() {
      System.out.println("Driving a ACCORD Car");
   }

   @Override
   public void displayMilesTraveled() {
      System.out.println("Miles traveled, displayed in ACCORD CAR");
   }
}
