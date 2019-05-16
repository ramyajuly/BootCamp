package com.company;
import java.util.Calendar;
public class AnalogClock implements Clock {
    Calendar calendar= Calendar.getInstance();
    @Override
    public void displayTime() {
        System.out.println("This is ANALOG clock display time");
        System.out.format("%tl:%tM %tp%n", calendar,calendar, calendar);
    }

    @Override
    public void timer() {
        System.out.println("This is ANALOG clock timer");
        System.out.format("%tl:%tM %tp%n", calendar,calendar, calendar);
    }
}
