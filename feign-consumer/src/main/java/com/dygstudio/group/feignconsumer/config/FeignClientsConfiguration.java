package com.dygstudio.group.feignconsumer.config;

import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: diyaguang
 * @date: 2018/05/30 上午11:36
 * @description: com.dygstudio.group.feignconsumer.config
 */
@Configuration
public class FeignClientsConfiguration {


    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }


}


