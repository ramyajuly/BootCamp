package com.company.restcalculatorservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.company.restcalculatorservice.model.Operands;

import javax.validation.Valid;


@RestController
public class RestCalculatorController {
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int addition(@RequestBody @Valid Operands operands) {

     return operands.getOperand1() + operands.getOperand2();
    }

    @RequestMapping(value = "/subtract", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int subtract(@RequestBody @Valid Operands operands) {

        return operands.getOperand1() - operands.getOperand2();
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public int multiply(@RequestBody @Valid Operands operands) {

        return operands.getOperand1() * operands.getOperand2();
    }

    @RequestMapping(value = "/divide", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public float divide(@RequestBody @Valid Operands operands) {

        return (float)operands.getOperand1() / (float)operands.getOperand2();
    }

}
