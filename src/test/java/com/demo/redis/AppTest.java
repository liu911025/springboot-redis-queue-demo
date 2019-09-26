package com.demo.redis;

import com.demo.redis.service.IProduceService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=DemoRedisApp.class)
public class AppTest {

	@Autowired
	IProduceService pro;

}
