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

    @RequestMapping(value = "/hello/world4")
    public String hello4() {

        return "Hello World4!";
    }

    @RequestMapping(value = "/hello/world6")
    public String hello6() {

        return "Hello World6!";
    }

    @RequestMapping(value = "/hello/world7")
    public String hello7() {

        return "Hello World7!";
    }

    @RequestMapping(value = "/hello/world8")
    public String hello8() {

        return "Hello World8!";
    }

    @RequestMapping(value = "/hello/world9")
    public String hello9() {

        return "Hello World9!";
    }



