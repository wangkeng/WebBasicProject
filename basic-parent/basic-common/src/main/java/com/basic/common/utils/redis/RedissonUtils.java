package com.basic.common.utils.redis;

import java.io.IOException;
import java.util.Map;

import org.redisson.Redisson;
import org.redisson.api.RAtomicLong;
import org.redisson.api.RBucket;
import org.redisson.api.RCountDownLatch;
import org.redisson.api.RDeque;
import org.redisson.api.RList;
import org.redisson.api.RLock;
import org.redisson.api.RMap;
import org.redisson.api.RQueue;
import org.redisson.api.RSet;
import org.redisson.api.RSortedSet;
import org.redisson.api.RTopic;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.common.utils.generator.CollectionObjectConvert;
@Service
public class RedissonUtils{
    @Autowired
    private RedissonClient redissonClient;
    
    public void getRedissonClient() throws IOException {
        Config config=((Redisson)redissonClient).getConfig();
        System.out.println(config.toJSON());
    }
    
    
    public RMap<String,Object> setMap(String key,Object obj) throws Exception{
    	Map<String, Object> paramMap = CollectionObjectConvert.obj2Map(obj);
    	return setMap(key,paramMap);
    }
    
    public RMap<String,Object> setMap(String key,Map<String, Object> paramMap) throws Exception{
    	RMap<String,Object> map=redissonClient.getMap(key);
    	for(String field : paramMap.keySet()){
    		map.put(field, paramMap.get(field));
    	}
    	return map ;
    }
    
    
    
    /** 
     * 获取字符串对象 
     * @param redisson 
     * @param t 
     * @param objectName 
     * @return 
     */  
    public <T> RBucket<T> getRBucket(String objectName){  
        RBucket<T> bucket=redissonClient.getBucket(objectName);  
        return bucket;  
    }  
      
    /** 
     * 获取Map对象 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <K,V> RMap<K, V> getRMap(String objectName){  
        RMap<K, V> map=redissonClient.getMap(objectName);  
        return map;  
    }  
      
    /** 
     * 获取有序集合 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RSortedSet<V> getRSortedSet(String objectName){  
        RSortedSet<V> sortedSet=redissonClient.getSortedSet(objectName);  
        return sortedSet;  
    }  
      
    /** 
     * 获取集合 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RSet<V> getRSet(String objectName){  
        RSet<V> rSet=redissonClient.getSet(objectName);  
        return rSet;  
    }  
      
    /** 
     * 获取列表 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RList<V> getRList(String objectName){  
        RList<V> rList=redissonClient.getList(objectName);  
        return rList;  
    }  
      
    /** 
     * 获取队列 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RQueue<V> getRQueue(String objectName){  
        RQueue<V> rQueue=redissonClient.getQueue(objectName);  
        return rQueue;  
    }  
      
    /** 
     * 获取双端队列 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <V> RDeque<V> getRDeque(String objectName){  
        RDeque<V> rDeque=redissonClient.getDeque(objectName);  
        return rDeque;  
    }  
      
    /** 
     * 此方法不可用在Redisson 1.2 中  
     * 在1.2.2版本中 可用 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    /** 
    public <V> RBlockingQueue<V> getRBlockingQueue(Redisson redisson,String objectName){ 
        RBlockingQueue rb=redisson.getBlockingQueue(objectName); 
        return rb; 
    }*/  
      
    /** 
     * 获取锁 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public RLock getRLock(String objectName){  
        RLock rLock=redissonClient.getLock(objectName);  
        return rLock;  
    }  
      
    /** 
     * 获取原子数 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public RAtomicLong getRAtomicLong(String objectName){  
        RAtomicLong rAtomicLong=redissonClient.getAtomicLong(objectName);  
        return rAtomicLong;  
    }  
      
    /** 
     * 获取记数锁 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public RCountDownLatch getRCountDownLatch(String objectName){  
        RCountDownLatch rCountDownLatch=redissonClient.getCountDownLatch(objectName);  
        return rCountDownLatch;  
    }  
      
    /** 
     * 获取消息的Topic 
     * @param redisson 
     * @param objectName 
     * @return 
     */  
    public <M> RTopic<M> getRTopic(String objectName){  
         RTopic<M> rTopic=redissonClient.getTopic(objectName);  
         return rTopic;  
    }  
    
    
}
