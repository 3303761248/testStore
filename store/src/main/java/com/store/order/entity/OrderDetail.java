package com.store.order.entity;

public class OrderDetail {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商品编号
     */
    private String goodCode;
    /**
     * 商品名称
     */
    private String goodName;
    /**
     * 购买数量
     */
    private String count;
    /**
     * 总金额
     */
    private String totalPrice;
    /**
     * 售价
     */
    private String sellPrice;
    /**
     * 定价
     */
    private String setPrice;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getGoodCode() {
        return goodCode;
    }

    public void setGoodCode(String goodCode) {
        this.goodCode = goodCode;
    }

    public String getGoodName() {
        return goodName;
    }

    public void setGoodName(String goodName) {
        this.goodName = goodName;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(String sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getSetPrice() {
        return setPrice;
    }

    public void setSetPrice(String setPrice) {
        this.setPrice = setPrice;
    }
}
