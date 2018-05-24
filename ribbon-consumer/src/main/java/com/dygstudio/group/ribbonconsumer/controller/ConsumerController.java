package com.dygstudio.group.ribbonconsumer.controller;

import com.dygstudio.group.ribbonconsumer.service.HelloService;
import com.dygstudio.group.ribbonconsumer.service.UserService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/05/09 上午11:34
 * @description: com.dygstudio.group.ribbonconsumer.controller
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.helloService();
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return userService.showInfo();
    }
}
