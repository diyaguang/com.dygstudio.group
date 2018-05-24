package com.dygstudio.group.ribbonconsumer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author: diyaguang
 * @date: 2018/05/24 下午3:28
 * @description: com.dygstudio.group.ribbonconsumer.service
 */
@Service
public class UserService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("microservice-provider-user");
    }
}
