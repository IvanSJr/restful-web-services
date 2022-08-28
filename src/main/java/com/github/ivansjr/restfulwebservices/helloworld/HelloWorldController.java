package com.github.ivansjr.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// REST API
@RestController
public class HelloWorldController {

    // / hello-world
    @GetMapping(value = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

}
