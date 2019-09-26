package com.demo.redis.service;

import com.alibaba.fastjson.JSON;
import com.demo.redis.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProduceServiceImpl implements IProduceService {

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private RedisTemplate redisTemplate1;

	private String redisKeySuff = "user_";

	@Override
	public void sendMsg(User user) {
		String s = JSON.toJSONString(user);
		redisTemplate.convertAndSend("myChannel", s);
	}

	@Override
	public void addCache(int num) {
		String redisKey = redisKeySuff + num;
		User user = new User(num);
		redisTemplate1.opsForValue().set(redisKey, JSON.toJSONString(user));
	}

	@Override
	public List<String> getCacheAll() {
		ValueOperations vops = redisTemplate1.opsForValue();
		String redisKey = redisKeySuff + "*";
		Set<String> keys = redisTemplate1.keys(redisKey);
		List<String> list = new ArrayList<String>();
		for (String key : keys) {
			String value = (String) vops.get(key);
			list.add(value);
		}
		return list;
	}

	@Override
	public void delCacheAll() {
		String redisKey = redisKeySuff + "*";
		Set<String> keys = redisTemplate1.keys(redisKey);
		if (!CollectionUtils.isEmpty(keys))
			redisTemplate1.delete(keys);
	}
}
