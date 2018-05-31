package com.dygstudio.group.feignconsumer.service;

import com.dygstudio.group.feignconsumer.config.FeignClientsConfiguration;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: diyaguang
 * @date: 2018/05/30 上午10:46
 * @description: com.dygstudio.group.feignconsumer.repository
 */
@Service
@FeignClient(name = "microservice-provider-user",configuration = FeignClientsConfiguration.class,fallbackFactory = FeignClientFallbackFactory.class)
public interface UserFeignClient {

    @RequestMapping(value="/users/{id}",method = RequestMethod.GET)
    public String findById(@PathVariable("id") Long id);
}

@Component
class FeignClientFallback implements UserFeignClient{

    @Override
    public String findById(Long id){
        return "default user,id:-1L,";
    }
}

@Component
class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{
    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause){
        return new UserFeignClient(){
            @Override
            public String findById(Long id) {
                //日志最好放在各个 fallback 方法中，不要直接放在 create方法中，否则在引用启动时，就会打印该日志。
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:",cause);
                return "default user,id:-1L,";
            }
        };
    }
}