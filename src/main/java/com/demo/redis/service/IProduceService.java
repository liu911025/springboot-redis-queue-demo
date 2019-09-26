package com.demo.redis.service;

import com.demo.redis.pojo.User;

import java.util.List;

public interface IProduceService {

    void sendMsg(User user);

    void addCache(int num);

    List<String> getCacheAll();

    void delCacheAll();
}
