package com.dubbo.common.utils.redis;
/*package com.dubbo.util;

import java.io.IOException;

import org.redisson.Redisson;
import org.redisson.api.RList;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
@Service
public class RedissonUtils {
    @Autowired
    private RedissonClient redissonClient;
    public void getRedissonClient() throws IOException {
        Config config=((Redisson)redissonClient).getConfig();
        System.out.println(config.toJSON());
    }
    
    
    public void add(){
    	RList<Object> rList = redissonClient.getList("helloRedisson");
    	rList.add("hello");
    }
    
    public void get(){
    	RList<Object> rList = redissonClient.getList("helloRedisson");
    	System.out.println(JSON.toJSONString(rList));
    	 Config config=((Redisson)redissonClient).getConfig();
         try {
			System.out.println(config.toJSON());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
*/