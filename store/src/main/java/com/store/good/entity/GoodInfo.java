package com.store.good.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class GoodInfo {
    /**
     * 页码
     */
    private int pageSize;
    /**
     * 页数
     */
    private int pageNum;
    /**
     * 商品名字
     */
    private String goodName;
    /**
     * 定价
     */
    private String setPrice;
    /**
     * 售价
     */
    private String sellPrice;
    /**
     * 销售量
     */
    private String saleCount;
    /**
     * 分类编号
     */
    private String cateCode;
    /**
     * 广告词
     */
    private String advert;
    /**
     * 书号
     */
    private String bookCode;
    /**
     * 商品介绍
     */
    private String goodIntroduction;
    /**
     * 商家名称
     */
    private String businessName;
    /**
     * 库存
     */
    private String stock;
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
     * 成本价
     */
    private String costPrice;
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 商品编状态（0下架1上架2未发布）
     */
    private int goodStatus;
    /**
     * 作者
     */
    private String author;
    /**
     * 游览量
     */
    private String visitCount;
    /**
     * 出版社
     */
    private String publisher;
    /**
     * 一级分类编号
     */
    private String firstSortCode;
    /**
     * 二级分类编号
     */
    private String secondSortCode;
    /**
     * 图片地址
     */
    private String photoUrl;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(String setPrice) {
        this.setPrice = setPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSaleCount() {
        return saleCount;
    }

    public void setSaleCount(String saleCount) {
        this.saleCount = saleCount;
    }

    public String getCateCode() {
        return cateCode;
    }

    public void setCateCode(String cateCode) {
        this.cateCode = cateCode;
    }

    public String getAdvert() {
        return advert;
    }

    public void setAdvert(String advert) {
        this.advert = advert;
    }

    public String getGoodIntroduction() {
        return goodIntroduction;
    }

    public void setGoodIntroduction(String goodIntroduction) {
        this.goodIntroduction = goodIntroduction;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
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

    public String getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(String costPrice) {
        this.costPrice = costPrice;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public int getGoodStatus() {
        return goodStatus;
    }

    public void setGoodStatus(int goodStatus) {
        this.goodStatus = goodStatus;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getFirstSortCode() {
        return firstSortCode;
    }

    public void setFirstSortCode(String firstSortCode) {
        this.firstSortCode = firstSortCode;
    }

    public String getSecondSortCode() {
        return secondSortCode;
    }

    public void setSecondSortCode(String secondSortCode) {
        this.secondSortCode = secondSortCode;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getBookCode() {
        return bookCode;
    }

    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }
}
