package com.devilhan.lock.redis.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: devilHan
 * @Date: 2021/12/1
 * @Description:
 */

@Component
@Aspect
@Slf4j
public class LockAop {

    private WebApplicationContext webApplicationContext;

//    RedisLockRegistry

    public LockAop  (WebApplicationContext webApplicationContext){
        this.webApplicationContext = webApplicationContext;
    }

    @Pointcut("@annotation(DistributedLock)")
    private void apiApp(){

    }
}
