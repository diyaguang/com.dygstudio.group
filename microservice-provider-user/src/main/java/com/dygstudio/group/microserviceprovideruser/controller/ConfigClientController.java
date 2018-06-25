package com.dygstudio.group.microserviceprovideruser.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: diyaguang
 * @date: 2018/06/05 下午2:09
 * @description: com.dygstudio.group.microserviceprovideruser.controller
 */
@RestController
@RefreshScope
public class ConfigClientController {

    @Autowired
    private Environment env;

    @Value("${profile}")
    private String profile;

    @GetMapping("/profile")
    public String hello(){
        return this.profile;
    }

    /*
    * Use the Environment object to get the configuration properties
    * */
    @GetMapping("/profile-environment")
    public String from(){
        return env.getProperty("profile","undefined");
    }
}
