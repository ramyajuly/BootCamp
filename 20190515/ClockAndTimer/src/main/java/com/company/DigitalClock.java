package com.company;
import java.util.Calendar;
public class DigitalClock implements Clock, Alarm {
    Calendar calendar= Calendar.getInstance();
    @Override
    public void Sound() {
        System.out.println("This is DIGITAL clock sound");
    }

    @Override
    public void displayTime() {
        System.out.println("This is DIGITAL clock display time");
        System.out.format("%tl:%tM %tp%n", calendar,calendar, calendar);

    }

    @Override
    public void timer() {
        System.out.println("This is DIGITAL clock timer");
        System.out.format("%tl:%tM %tp%n", calendar,calendar, calendar);
    }
}
