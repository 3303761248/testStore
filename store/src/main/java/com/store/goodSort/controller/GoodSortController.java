package com.store.goodSort.controller;

import com.store.goodSort.entity.GoodSortInfo;
import com.store.goodSort.service.GoodSortService;
import com.store.util.AppResponse;
import com.store.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 商品分类管理
 * huangzewei
 * 2020-04-08
 */
@RestController
@RequestMapping("/goodSort")
public class GoodSortController {
    private static final Logger logger = LoggerFactory.getLogger(GoodSortController.class);

    @Resource
    private GoodSortService goodSortService;

    /**
     * 新增一级分类商品
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @PostMapping("/addFirstGoodSort")
    public AppResponse addFirstGoodSort(GoodSortInfo goodSortInfo) {
        try {
            AppResponse appResponse = goodSortService.addFirstGoodSort(goodSortInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品一级分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 新增二级分类商品
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @PostMapping("/addSecondGoodSort")
    public AppResponse addSecondGoodSort(GoodSortInfo goodSortInfo) {
        try {
            AppResponse appResponse = goodSortService.addSecondGoodSort(goodSortInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品二级分类新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询商品分类详情
     *
     * @param goodSortCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @RequestMapping("/findGoodSortDetail")
    public AppResponse findGoodSortDetail(String goodSortCode) {
        try {
            return goodSortService.findGoodSortDetail(goodSortCode);
        } catch (Exception e) {
            logger.error("商品查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改商品分类
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @PostMapping("/updateGoodSort")
    public AppResponse updateGoodSort(GoodSortInfo goodSortInfo) {
        try {
            return goodSortService.updateGoodSort(goodSortInfo);
        } catch (Exception e) {
            logger.error("修改商品分类信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 删除商品分类
     *
     * @param goodSortCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @PostMapping("/deleteGoodSort")
    public AppResponse deleteGoodSort(String goodSortCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return goodSortService.deleteGoodSort(goodSortCode, userId);
        } catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 商品分类列表(分页)
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @RequestMapping("/listGoodSorts")
    public AppResponse listGoodSorts(GoodSortInfo goodSortInfo) {
        try {
            return goodSortService.listGoodSorts(goodSortInfo);
        } catch (Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询一级分类
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @RequestMapping("/findFirstSort")
    public AppResponse findFirstSort(GoodSortInfo goodSortInfo) {
        try {
            return goodSortService.findFirstSort(goodSortInfo);
        } catch (Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 查询二级分类
     *
     * @param goodSortInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-08
     */
    @RequestMapping("/findSecondSort")
    public AppResponse findSecondSort(GoodSortInfo goodSortInfo) {
        try {
            return goodSortService.findSecondSort(goodSortInfo);
        } catch (Exception e) {
            logger.error("查询商品分类列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
