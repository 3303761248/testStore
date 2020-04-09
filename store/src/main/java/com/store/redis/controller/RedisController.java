package com.store.redis.controller;

import com.store.good.entity.GoodInfo;
import com.store.redis.service.RedisService;
import com.store.util.AppResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Redis
 * @author huangzewei
 * @time 2020-03-30
 */
@RestController
@RequestMapping("/redis")
public class RedisController {
    @Resource
    private RedisService redisService;
    /**
     * redis Redis练习
     * @param key

     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-30
     */
    @PostMapping("/queryGoodList")
    public AppResponse queryGoodList(String key, GoodInfo goodInfo){
        try{
            return redisService.queryGoodList(key,goodInfo);
        } catch (Exception e){
            System.out.println(e.toString());
            throw e;
        }
    }
   /**
     * redis Redis练习
     * @param key
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-30
     */
    @PostMapping("/redisGet")
    public AppResponse redisGet(String key){
        try{
            return redisService.redisGet(key);
        } catch (Exception e){
            System.out.println(e.toString());
            throw e;
        }
    }


    }




