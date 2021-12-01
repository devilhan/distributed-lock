package com.devilhan.lock.redis;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;

import javax.annotation.Resource;
import java.util.List;
import java.util.Arrays;

/**
 * @Author: devilHan
 * @Date: 2021/11/30
 * @Description:
 */

@Configuration
public class RedisLuaLock {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Resource
    private DefaultRedisScript set;
    @Resource
    private DefaultRedisScript del;

    @Bean("set")
    public DefaultRedisScript<Boolean> redisScriptSet(){
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/lock-set.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }

    @Bean("del")
    public DefaultRedisScript<Boolean> redisScriptDel(){
        DefaultRedisScript<Boolean> redisScript = new DefaultRedisScript<>();
        redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("/lock-del.lua")));
        redisScript.setResultType(Boolean.class);
        return redisScript;
    }

    public void test(){
        List<String> keys = Arrays.asList("testLua");
        redisTemplate.execute(set, keys,"100");
        redisTemplate.execute(del,keys,"testLua");
    }

}
