package com.store.goodSort.service;

import com.store.goodSort.dao.GoodSortDao;
import com.store.goodSort.entity.GoodSortInfo;
import com.store.util.AppResponse;
import com.store.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 商品分类管理
 * huangzewei
 * 2020-04-08
 */
@Service
public class GoodSortService {
    @Resource
    private GoodSortDao goodSortDao;
    /**
     * 新增一级分类
     *
     * @param goodSortInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addFirstGoodSort(GoodSortInfo goodSortInfo) {
        // 校验商品是否存在
        int countGoodSortName = goodSortDao.countGoodSortName(goodSortInfo);
        if (0 != countGoodSortName) {
            return AppResponse.bizError("商品分类名字已存在，请重新输入！");
        }
        goodSortInfo.setGoodSortCode(StringUtil.getCommonCode(2));
        goodSortInfo.setCreateUser("admin");
        goodSortInfo.setIsDeleted(0);
        // 新增一级分类商品
        int count = goodSortDao.addFirstGoodSort(goodSortInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 新增二级分类
     *
     * @param goodSortInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSecondGoodSort(GoodSortInfo goodSortInfo) {
        // 校验商品是否存在
        int countGoodSortName = goodSortDao.countGoodSortName(goodSortInfo);
        if (0 != countGoodSortName) {
            return AppResponse.bizError("商品分类名字已存在，请重新输入！");
        }
        goodSortInfo.setGoodSortCode(StringUtil.getCommonCode(2));
        goodSortInfo.setCreateUser("admin");
        goodSortInfo.setIsDeleted(0);
        // 新增二级分类商品
        int count = goodSortDao.addSecondGoodSort(goodSortInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
    /**
     * 查询商品详情
     *
     * @param goodSortCode
     * @return
     */
    public AppResponse findGoodSortDetail(String goodSortCode) {
        GoodSortInfo goodSortInfo = goodSortDao.findGoodSortDetail(goodSortCode);
        if(goodSortInfo!=null){
            return AppResponse.success("查询成功！", goodSortInfo);
        }else{
            return AppResponse.bizError("查询失败！");
        }
    }
    /**
     * 删除商品分类
     *
     * @param goodSortCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodSort(String goodSortCode, String userId) {
        List<String> listCode = Arrays.asList(goodSortCode.split(","));
        // 删除商品分类
        int count = goodSortDao.deleteGoodSort(listCode, userId);
        if (0 == count) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
    /**
     * 修改商品分类
     *
     * @param goodSortInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodSort(GoodSortInfo goodSortInfo) {
        // 修改商品信息
        int count = goodSortDao.updateGoodSort(goodSortInfo);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }else{
            return AppResponse.success("修改成功");
        }
    }
    /**
     * 查询商品分类列表
     *
     * @param goodSortInfo
     * @return
     */
    public AppResponse listGoodSorts(GoodSortInfo goodSortInfo) {
        List<GoodSortInfo> goodInfoList = goodSortDao.listGoodSorts(goodSortInfo);
        if(goodInfoList!=null){
            return AppResponse.success("查询成功！", goodInfoList);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
    /**
     * 查询一级分类列表
     *
     * @param goodSortInfo
     * @return
     */
    public AppResponse findFirstSort(GoodSortInfo goodSortInfo) {
        List<GoodSortInfo> goodInfoList = goodSortDao.findFirstSort(goodSortInfo);
        if(goodInfoList!=null){
            return AppResponse.success("查询成功！", goodInfoList);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
    /**
     * 查询二级分类列表
     *
     * @param goodSortInfo
     * @return
     */
    public AppResponse findSecondSort(GoodSortInfo goodSortInfo) {
        List<GoodSortInfo> goodInfoList = goodSortDao.findSecondSort(goodSortInfo);
        if(goodInfoList!=null){
            return AppResponse.success("查询成功！", goodInfoList);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }

    }
}
