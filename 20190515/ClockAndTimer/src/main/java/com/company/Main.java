package com.company;

public class Main {
    public static void main(String[] args) {
        AnalogClock analogClock = new AnalogClock();
        analogClock.displayTime();
        analogClock.timer();
        System.out.println("----------------------");
        Buzzer buzzer = new Buzzer();
        buzzer.Sound();
        System.out.println("----------------------");
        DigitalClock digitalClock = new DigitalClock();
        digitalClock.displayTime();
        digitalClock.timer();
        digitalClock.Sound();
    }
}
