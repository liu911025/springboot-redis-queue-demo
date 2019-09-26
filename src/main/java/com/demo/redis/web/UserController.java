package com.demo.redis.web;

import com.demo.redis.pojo.User;
import com.demo.redis.service.IProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private IProduceService produceService;

    @GetMapping("send")
    public String send() {
        Random random = new Random();
        User user = new User(random.nextInt(100));
        produceService.sendMsg(user);
        return "success";
    }

    @GetMapping("addCache")
    public String addCache() {
        Random random = new Random();
        produceService.addCache(random.nextInt(100));
        return "success";
    }

    @GetMapping("getCacheAll")
    public List<String> getCacheAll() {
        List<String> cacheAll = produceService.getCacheAll();
        return cacheAll;
    }

    @GetMapping("delCacheAll")
    public String delCacheAll() {
        produceService.delCacheAll();
        return "success";
    }
}
