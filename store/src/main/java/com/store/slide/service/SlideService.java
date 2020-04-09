package com.store.slide.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.good.entity.GoodInfo;
import com.store.slide.dao.SlideDao;
import com.store.slide.entity.SlideInfo;
import com.store.util.AppResponse;
import com.store.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author huangzewei
 * @Date 2020-03-28
 */
@Service
public class SlideService {
    @Resource
    private SlideDao slideDao;
    /**
     * slide 新增轮播图
     *
     * @param slideInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSlideChart(SlideInfo slideInfo) {
        slideInfo.setSlideCode(StringUtil.getCommonCode(2));
        slideInfo.setIsDeleted(0);
        // 新增轮播图
        int count = slideDao.addSlideChart(slideInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * slide 查询轮播图列表（分页）
     *
     * @param slideInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-28
     */
    public AppResponse listSlideCharts(SlideInfo slideInfo) {
        PageHelper.startPage(slideInfo.getPageNum(), slideInfo.getPageSize());
        List<SlideInfo> goodInfoList = slideDao.listSlidesByPage(slideInfo);
        // 包装Page对象
        PageInfo<SlideInfo> pageData = new PageInfo<SlideInfo>(goodInfoList);
        if(pageData!=null){
            return AppResponse.success("查询成功！", pageData);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
    /**
     * slide 删除轮播图
     *
     * @param slideCode
     * @param userId
     * @return
     * @Author huangzewei
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlideChart(String slideCode, String userId) {
        List<String> listCode = Arrays.asList(slideCode.split(","));
        // 删除轮播图
        int count = slideDao.deleteSlideChart(listCode, userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
    /**
     * 轮播图 修改轮播图状态
     *
     * @param slideInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-03-28
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideChartStatus(SlideInfo slideInfo) {
        // 修改轮播图信息
        int count = slideDao.updateSlideChartStatus(slideInfo);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }else{
            return AppResponse.success("修改成功");
        }
    }
    /**
     * slide 查询轮播图新增商品选择列表列表（分页）
     *
     * @param goodInfo
     * @return
     * @Author huangzewei
     * @Date 2020-03-28
     */
    public AppResponse listSlideCharts2(GoodInfo goodInfo) {
        PageHelper.startPage(goodInfo.getPageNum(), goodInfo.getPageSize());
        List<SlideInfo> goodInfoList = slideDao.listSlidesByPage2(goodInfo);
        // 包装Page对象
        PageInfo<SlideInfo> pageData = new PageInfo<SlideInfo>(goodInfoList);
        if(pageData!=null){
            return AppResponse.success("查询成功！", pageData);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
}
