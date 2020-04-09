package com.store.customer.controller;

import com.store.customer.entity.CustomerInfo;
import com.store.customer.service.CustomerService;
import com.store.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description查
 * @Author huangzewei
 * @Date 2020-04-04
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
    @Resource
    private CustomerService customerService;
    /**
     * customer 客户列表（分页）
     * @param customerInfo
     * @return AppResponse
     * @authoe huangzewei
     * @Date 2020-04-04
     */
    @RequestMapping("listCustomers")
    public AppResponse listCustomers(CustomerInfo customerInfo){
        try {
            return customerService.listCustomers(customerInfo);
        }catch (Exception e){
            logger.error("查询客户列表异常",e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
