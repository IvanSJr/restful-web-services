package com.github.ivansjr.restfulwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

// REST API
@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // / hello-world
    @GetMapping(value = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    // / hello-world
    @GetMapping(value = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(value = "/hello-world-bean/path-variable/{name}")
    public HelloWorldBean helloWorldBean(@PathVariable String name){
        return new HelloWorldBean("Hello World " + name);
    }

    @GetMapping(value = "/hello-world-internationalization")
    public String helloWorldInternationalization(){
        Locale locale = LocaleContextHolder.getLocale();
        return  messageSource.getMessage("good.morning.message", null, "Default Message", locale);
    }


}
