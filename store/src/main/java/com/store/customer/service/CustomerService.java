package com.store.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.customer.dao.CustomerDao;
import com.store.customer.entity.CustomerInfo;
import com.store.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerService {
    @Resource
    private CustomerDao customerDao;
    /**
     * customer 查询客户列表（分页）
     * @param customerInfo
     * @return AppResponse
     * @author huangzewei
     * @Date 2020-04-04
     */
    public AppResponse listCustomers(CustomerInfo customerInfo){
        PageHelper.startPage(customerInfo.getPageNum(),customerInfo.getPageSize());
        List<CustomerInfo> customerInfoList = customerDao.listCustomers(customerInfo);
        PageInfo<CustomerInfo> pageData = new PageInfo<CustomerInfo>(customerInfoList);
        if(pageData!=null){
            return AppResponse.success("查询成功！", pageData);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }
    }
}
