package com.company.monthconverter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class MonthConverterController {
    @RequestMapping(value = "/monthconverter/{monthNum}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String convertToMonth(@PathVariable int monthNum) {

        String month = "";
        switch (monthNum) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
            default:
                throw new IllegalArgumentException("You must enter a whole number between 1 and 12.");

        }
        return month;

    }
}
