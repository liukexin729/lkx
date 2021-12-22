package com.ecloud.springbootsender.controller;

import com.alibaba.fastjson.JSON;
import com.ecloud.common_l.annotation.Log;
import com.ecloud.common_l.entity.LogType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class LogController {

    @Log(logType=LogType.REGISTER,content = "用户注册")
    @PostMapping("/register")
    public String register(@RequestParam Map<String,Object> map) {
        System.out.println(JSON.toJSONString(map));
        return "success";
    }

}
