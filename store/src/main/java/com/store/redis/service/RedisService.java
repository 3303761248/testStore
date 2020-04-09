package com.store.redis.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.good.dao.GoodDao;
import com.store.good.entity.GoodInfo;
import com.store.user.entity.UserInfo;
import com.store.util.AppResponse;
import com.store.util.JsonUtils;
import com.store.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@Service
public class RedisService {
    @Autowired
    private RedisOperator redisOperator;
    @Resource
    private GoodDao goodDao;
    String keySet;
    /**
     * redis Redis练习
     * @param key
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-30
     */
    public AppResponse queryGoodList(String key,GoodInfo goodInfo){
       /* if(time != 0){
            redisOperator.set(key,value,time);
        }else {
            redisOperator.set(key,value);
        }*/
       // keySet = good.getAuthor()+" "+good.getAdvert()+" "+good.getBookCode()+" "+good.getGoodName();
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodsList = goodDao.listGoodsByPage(goodInfo);
        // 包装Page对象
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodsList);
        String json = JsonUtils.toJson(pageData);
        //String result = redisOperator.get(key);
        redisOperator.set(key,json,300);
        String result = redisOperator.get(key);
        GoodInfo goodInfos = JsonUtils.fromJson(result,GoodInfo.class);
        return AppResponse.success("操作成功",goodInfos);
    }
    /**
     * redis Redis练习
     * @param key
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-30
     */
    public AppResponse redisGet(String key){
        String result = redisOperator.get(key);
       /* GoodInfo goodInfo = JsonUtils.fromJson(result,GoodInfo.class);
        return AppResponse.success("操作成功",goodInfo);*/
        return AppResponse.success("操作成功",result);
    }
}
