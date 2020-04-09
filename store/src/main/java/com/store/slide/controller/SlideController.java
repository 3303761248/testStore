package com.store.slide.controller;

import com.store.good.entity.GoodInfo;
import com.store.slide.entity.SlideInfo;
import com.store.slide.service.SlideService;
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
 * @Date 2020-03-28
 */
@RestController
@RequestMapping("/slide")
public class SlideController {
    private static final Logger logger = LoggerFactory.getLogger(SlideController.class);

    @Resource
    private SlideService slideService;

    /**
     * slide 新增轮播图
     *
     * @param slideInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-28
     */
    @PostMapping("/addSlideChart")
    public AppResponse addSlideChart(SlideInfo slideInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            slideInfo.setCreateUser(userId);
            AppResponse appResponse = slideService.addSlideChart(slideInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("轮播图新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * slide 轮播图列表(分页)
     *
     * @param slideInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-28
     */
    @PostMapping("/listSlideCharts")
    public AppResponse listSlideCharts(SlideInfo slideInfo) {
        try {
            return slideService.listSlideCharts(slideInfo);
        } catch (Exception e) {
            logger.error("查询轮播图列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 轮播图 删除轮播图
     *
     * @param slideCode
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-28
     */
    @PostMapping("/deleteSlideChart")
    public AppResponse deleteSlideChart(String slideCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return slideService.deleteSlideChart(slideCode, userId);
        } catch (Exception e) {
            logger.error("轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 轮播图 修改轮播图状态
     *
     * @param slideInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-28
     */
    @PostMapping("/updateSlideChartStatus")
    public AppResponse updateShelvesGood(SlideInfo slideInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            slideInfo.setUpdateUser(userId);
            return slideService.updateSlideChartStatus(slideInfo);
        } catch (Exception e) {
            logger.error("修改轮播图信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * slide 轮播图新增商品列表选择(分页)
     *
     * @param goodInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-28
     */
    @PostMapping("/listSlideCharts2")
    public AppResponse listSlideCharts2(GoodInfo goodInfo) {
        try {
            return slideService.listSlideCharts2(goodInfo);
        } catch (Exception e) {
            logger.error("查询轮播图商品选择列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
