package com.company.dayconverter.controller;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class DayCoverterController {
    @RequestMapping(value = "/dayconverter/{day}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String dayConverter(@PathVariable int day) {
        String dayWeek = "";
        switch (day) {
            case 1:
                dayWeek = "Sunday";
                break;
            case 2:
                dayWeek = "Monday";
                break;
            case 3:
                dayWeek = "Tuesday";
                break;
            case 4:
                dayWeek = "Wednesday";
                break;
            case 5:
                dayWeek = "Thursday";
                break;
            case 6:
                dayWeek = "Friday";
                break;
            case 7:
                dayWeek = "Saturday";
                break;
            default:
                throw new IllegalArgumentException("You must enter a whole number between 1 and 7.");

        }
        return dayWeek;
    }
}
