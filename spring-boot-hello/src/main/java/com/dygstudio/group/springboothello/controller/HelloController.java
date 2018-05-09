package com.dygstudio.group.springboothello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

/**
 * @author: diyaguang
 * @date: 2018/05/08 下午5:37
 * @description: com.dygstudio.group.springboothello.controller
 */
@RestController
public class HelloController {
    private final Logger logger = Logger.getLogger(getClass().toString());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:"+instance.getHost()+", service_id:"+instance.getServiceId());
        return "Hello World";
    }
}
