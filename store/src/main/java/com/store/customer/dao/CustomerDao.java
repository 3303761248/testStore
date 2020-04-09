package com.store.customer.dao;

import com.store.customer.entity.CustomerInfo;

import java.util.List;

/**
 * @ClassName CustomerDao
 * @Description Customer
 * @Author huangzewei
 * @Date 2020-04-04
 */
public interface CustomerDao {
    /**
     * 获取所有客户信息
     * @param customerInfo 客户信息
     * @return 所有客户信息
     */
    List<CustomerInfo> listCustomers(CustomerInfo customerInfo);
}
