package com.dygstudio.group.springboothello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.actuate.metrics.CounterService;
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

    @Autowired
    //Using this code can remove an error message."Could not autowire. There is more than one bean of'CounterService'of"
    @Qualifier("counterService")
    private CounterService counterService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:"+instance.getHost()+", service_id:"+instance.getServiceId());
        /*
        * Here is the custom of a statistical information,
        * through the org.springframework.boot.actuate.metrics.CounterService interface,
        * custom statistical indicators, and then through the /metrics to see the relevant index information.
        */
        counterService.increment("didispace.hello.count");
        return "Hello World";
    }
}
