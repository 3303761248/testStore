package com.store.goodSort.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class GoodSortInfo {
    /**
     * 分类编号
     */
    private String goodSortCode;
    /**
     * 分类名称
     */
    private String goodSortName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 分类等级
     */
    private String rank;
    /**
     * 所属一级分类编号
     */
    private String firstSortCode;
    /**
     * 父类编码
     */
    private String parentCode;
    /**
     *删除标记0未删1已删
     */
    private int isDeleted;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    /**
     * 修改人
     */
    private String updateUser;
    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date updateTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 二级列表信息
     */
    private List<GoodSortList> secondList;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getFirstSortCode() {
        return firstSortCode;
    }

    public void setFirstSortCode(String firstSortCode) {
        this.firstSortCode = firstSortCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<GoodSortList> getSecondList() {
        return secondList;
    }

    public void setSecondList(List<GoodSortList> secondList) {
        this.secondList = secondList;
    }
}
