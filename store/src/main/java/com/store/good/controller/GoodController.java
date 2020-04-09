package com.store.good.controller;

import com.store.good.entity.GoodInfo;
import com.store.good.service.GoodService;
import com.store.util.AppResponse;
import com.store.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description增删改查
 * @Author huangzewei
 * @Date 2020-03-26
 */
@RestController
@RequestMapping("/good")
public class GoodController {
    private static final Logger logger = LoggerFactory.getLogger(GoodController.class);

    @Resource
    private GoodService goodService;

    /**
     * good 新增商品
     *
     * @param goodInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("/addGood")
    public AppResponse addGood(GoodInfo goodInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodInfo.setCreateUser(userId);
            AppResponse appResponse = goodService.addGood(goodInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * good 商品列表(分页)
     *
     * @param goodInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @RequestMapping("/listGoods")
    public AppResponse listGoods(GoodInfo goodInfo) {
        try {
            return goodService.listGoods(goodInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品 删除商品
     *
     * @param goodCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("/deleteGood")
    public AppResponse deleteGood(String goodCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return goodService.deleteGood(goodCode, userId);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * good 修改商品
     *
     * @param goodInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("/updateGood")
    public AppResponse updateUser(GoodInfo goodInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodInfo.setUpdateUser(userId);
            return goodService.updateGood(goodInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * good查询商品详情
     *
     * @param goodCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @RequestMapping(value = "findGoodDetail")
    public AppResponse findGoodDetail(String goodCode) {
        try {
            return goodService.findGoodDetail(goodCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * good 修改商品上架下架
     *
     * @param goodInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-26
     */
    @PostMapping("/updateShelvesGood")
    public AppResponse updateShelvesGood(GoodInfo goodInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodInfo.setUpdateUser(userId);
            return goodService.updateShelvesGood(goodInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}

