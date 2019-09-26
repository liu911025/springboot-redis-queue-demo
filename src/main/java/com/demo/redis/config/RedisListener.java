package com.demo.redis.config;

import com.alibaba.fastjson.JSON;
import com.demo.redis.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RedisListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        String msg = new String(body);
        log.info("接受到消息:{}", msg);
        User user = JSON.parseObject(msg, User.class);
        log.info(user.toString());
    }
}
