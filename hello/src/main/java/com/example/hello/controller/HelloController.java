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
}
