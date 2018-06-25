package com.dygstudio.group.streamserver.service;

import com.dygstudio.group.streamserver.StreamServerApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * @author: diyaguang
 * @date: 2018/06/25 下午4:40
 * @description: com.dygstudio.group.streamserver.service
 */
@EnableBinding(Sink.class)
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(StreamServerApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("Received:"+payload);
    }
}
