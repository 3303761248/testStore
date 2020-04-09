package com.store.goodSort.dao;

import com.store.goodSort.entity.GoodSortInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品分类管理Dao
 * huangzewei
 * 2020-04-08
 */
public interface GoodSortDao {
    /**
     * 统计商品分类数量
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int countGoodSortName(GoodSortInfo goodSortInfo);
    /**
     * 新增一级分类商品
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int addFirstGoodSort(GoodSortInfo goodSortInfo);
    /**
     * 新增二级分类商品
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int addSecondGoodSort(GoodSortInfo goodSortInfo);
    /**
     * 查询商品分类详情
     * @param goodSortCode 商品分类编号
     * @return
     */
    GoodSortInfo findGoodSortDetail(@Param("goodSortCode") String goodSortCode);
    /**
     * 删除商品分类信息
     * @param listCode 选中的商品分类编号集合
     * @param userId 更新人
     * @return
     */
    int deleteGoodSort(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
     * 修改商品分类信息
     * @param goodSortInfo 商品分类信息
     * @return
     */
    int updateGoodSort(GoodSortInfo goodSortInfo);
    /**
     * 获取所有商品分类信息
     * @param goodSortInfo 商品分类信息
     * @return
     */
    List<GoodSortInfo> listGoodSorts(GoodSortInfo goodSortInfo);
    /**
     * 查询一级分类列表信息
     * @param goodSortInfo 商品分类信息
     * @return
     */
    List<GoodSortInfo> findFirstSort(GoodSortInfo goodSortInfo);
    /**
     * 查询二级分类列表信息
     * @param goodSortInfo 商品分类信息
     * @return
     */
    List<GoodSortInfo> findSecondSort(GoodSortInfo goodSortInfo);
}
