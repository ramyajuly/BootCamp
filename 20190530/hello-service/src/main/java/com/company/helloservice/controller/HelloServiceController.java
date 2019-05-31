package com.company.helloservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloServiceController {
    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingName(@PathVariable String name){
        return "Hello " + name + " !";
    }
}
