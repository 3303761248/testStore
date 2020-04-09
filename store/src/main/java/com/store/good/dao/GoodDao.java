package com.store.good.dao;

import com.store.good.entity.GoodInfo;
import org.apache.ibatis.annotations.Param;


import java.util.List;

    /**
     * @ClassName GoodDao
     * @Description Good
     * @Author huangzewei
     * @Date 2020-03-26
     */
public interface GoodDao {
    /**
     * 统计商品数量
     * @param goodInfo 商品信息
     * @return
     */
    int countGoodName(GoodInfo goodInfo);
    int countBookCode(GoodInfo goodInfo);
    /**
     * 新增商品
     * @param goodInfo 商品信息
     * @return
     */
    int addGood(GoodInfo goodInfo);
    /**
     * 获取所有商品信息
     * @param goodInfo 商品信息
     * @return 所有商品信息
     */
    List<GoodInfo> listGoodsByPage(GoodInfo goodInfo);
    /**
     * 删除商品信息
     * @param listCode 选中的商品编号集合
     * @param userId 更新人
     * @return
     */
    int deleteGood(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    /**
     * 修改商品信息
     * @param goodInfo 商品信息
     * @return 修改结果
     */
    int updateGood(GoodInfo goodInfo);
    /**
     * 查询商品信息
     * @param goodCode 商品编号
     * @return 修改结果
     */
    GoodInfo findGoodDetail(@Param("goodCode") String goodCode);
        /**
         * 修改商品上架下架
         * @param goodInfo
         * @return 修改结果
         */
     int updateShelvesGood(GoodInfo goodInfo);
    }

