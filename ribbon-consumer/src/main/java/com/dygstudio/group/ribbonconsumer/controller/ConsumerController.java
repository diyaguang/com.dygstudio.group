package com.dygstudio.group.ribbonconsumer.controller;

import com.dygstudio.group.ribbonconsumer.service.HelloService;
import com.dygstudio.group.ribbonconsumer.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/05/09 上午11:34
 * @description: com.dygstudio.group.ribbonconsumer.controller
 */
@RestController
public class ConsumerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerController.class);

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

    @GetMapping("/log-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = userService.getUserInstance();
        ConsumerController.LOGGER.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }
}
