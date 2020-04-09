package com.store.slide.dao;

import com.store.good.entity.GoodInfo;
import com.store.slide.entity.SlideInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName SlideDao
 * @Description Slide
 * @Author huangzewei
 * @Date 2020-03-28
 */
public interface SlideDao {
    /**
     * 新增轮播图
     * @param slideInfo 轮播图信息
     * @return
     */
    int addSlideChart(SlideInfo slideInfo);
    /**
     * 获取所有轮播图信息
     * @param slideInfo 轮播图信息
     * @return 所有轮播图信息
     */
    List<SlideInfo> listSlidesByPage(SlideInfo slideInfo);

    /**
     * 删除轮播图信息
     * @param listCode 选中的轮播图编号集合
     * @param userId 更新人
     * @return
     */
    int deleteSlideChart(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 修改轮播图状态
     * @param slideInfo
     * @return 修改结果
     */
    int updateSlideChartStatus(SlideInfo slideInfo);

    /**
     * 获取轮播图新增所有商品信息
     * @param goodInfo 轮播图商品信息
     * @return 所有轮播图商品信息
     */
    List<SlideInfo> listSlidesByPage2(GoodInfo goodInfo);
}
