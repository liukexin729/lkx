package com.ecloud.controllers;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 基础 ping
 *
 * @author eric
 */
@RestController
@RequestMapping(value = "/")
public class BaseController {

    @PostMapping(value = "ping")
    public String ping(@RequestParam Map<String, Object> map) {
        return "pong";
    }

}