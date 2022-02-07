package com.example.hello.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 */
@RestController
public class HelloController {

    @RequestMapping(value = "/hello/world")
    public String hello() {

        return "Hello World!";
    }

    @RequestMapping(value = "/hello/world1")
    public String hello1() {

        return "Hello World1!";
    }
    
    @RequestMapping(value = "/hello/world2")
    public String hello2() {

        return "Hello World2!";
    }

    @RequestMapping(value = "/hello/world3")
    public String hello3() {

        return "Hello World3!";
    }

}
