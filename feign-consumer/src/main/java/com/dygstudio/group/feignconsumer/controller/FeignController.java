package com.dygstudio.group.feignconsumer.controller;

import com.dygstudio.group.feignconsumer.service.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: diyaguang
 * @date: 2018/05/30 上午10:56
 * @description: com.dygstudio.group.feignconsumer.controller
 */
@RestController
public class FeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public String findById(@PathVariable Long id){
        return this.userFeignClient.findById(id);
    }
}
