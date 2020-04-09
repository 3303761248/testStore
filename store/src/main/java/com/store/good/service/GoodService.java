package com.store.good.service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/*import com.store.activcemq.dao.ConsumerDao;*/
import com.store.good.dao.GoodDao;
import com.store.good.entity.GoodInfo;
import com.store.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springfox.documentation.spring.web.json.Json;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.Queue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionGood 实现类
 * @Author huangzewei
 * @Date 2020-03-28
 */
@Service
public class GoodService {
   /* @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;*/
    @Resource
    private GoodDao goodDao;
    /**
     * good 新增商品
     *
     * @param goodInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGood(GoodInfo goodInfo) {
        // 校验商品是否存在
        int countGoodName = goodDao.countGoodName(goodInfo);
        int countBookCode = goodDao.countBookCode(goodInfo);
        if (0 != countGoodName) {
            return AppResponse.bizError("商品名字已存在，请重新输入！");
        }
        if (0 != countBookCode) {
            return AppResponse.bizError("商品书号已存在，请重新输入！");
        }

        goodInfo.setGoodCode(StringUtil.getCommonCode(2));
        goodInfo.setIsDeleted(0);
        // 新增商品
        int count = goodDao.addGood(goodInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
       /* String json = JSON.toJSONString(goodInfo);*/
       /* String json = JsonUtils.toJson(goodInfo);
        sendMessage(queue,json);*/
        return AppResponse.success("新增成功！");

    }
    /*// 发送消息，destination是发送到的队列，message是待发送的消息
    private void sendMessage(Destination destination, final String message){
        jmsMessagingTemplate.convertAndSend(destination, message);
    }*/
    /**
     * good 查询商品列表（分页）
     *
     * @param goodInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    public AppResponse listGoods(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<GoodInfo> goodInfoList = goodDao.listGoodsByPage(goodInfo);
        // 包装Page对象
        PageInfo<GoodInfo> pageData = new PageInfo<GoodInfo>(goodInfoList);
        if(pageData!=null){
            return AppResponse.success("查询成功！", pageData);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
    /**
     * good 删除商品
     *
     * @param goodCode
     * @param userId
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGood(String goodCode, String userId) {
        List<String> listCode = Arrays.asList(goodCode.split(","));
        // 删除商品
        int count = goodDao.deleteGood(listCode, userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
    /**
     * good 修改商品
     *
     * @param goodInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGood(GoodInfo goodInfo) {
        // 校验商品是否存在
        int countUserAcct = goodDao.countGoodName(goodInfo);
        if (0 != countUserAcct) {
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        // 修改商品信息
        int count = goodDao.updateGood(goodInfo);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }else{
            return AppResponse.success("修改成功");
        }
    }
    /**
     * good 查询商品详情
     *
     * @param goodCode
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    public AppResponse findGoodDetail(String goodCode) {
        GoodInfo goodInfo = goodDao.findGoodDetail(goodCode);
        if(goodInfo!=null){
            return AppResponse.success("查询成功！", goodInfo);
        }else{
            return AppResponse.bizError("查询失败！");
        }
    }
    /**
     * good 修改商品上架下架
     *
     * @param goodInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShelvesGood(GoodInfo goodInfo) {
        // 修改商品信息
        int count = goodDao.updateShelvesGood(goodInfo);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }else{
            return AppResponse.success("修改成功");
        }
    }


}

