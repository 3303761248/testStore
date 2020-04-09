package com.store.goodSort.entity;

import java.util.List;

public class GoodSortList {
    /**
     * 分类编号
     */
    private String goodSortCode;
    /**
     * 分类名称
     */
    private String goodSortName;
    /**
     * 分类等级
     */
    private String rank;

    public String getGoodSortCode() {
        return goodSortCode;
    }

    public void setGoodSortCode(String goodSortCode) {
        this.goodSortCode = goodSortCode;
    }

    public String getGoodSortName() {
        return goodSortName;
    }

    public void setGoodSortName(String goodSortName) {
        this.goodSortName = goodSortName;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
