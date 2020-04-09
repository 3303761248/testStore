package com.store.order.controller;

import com.store.order.entity.OrderList;
import com.store.order.service.OrderService;
import com.store.util.AppResponse;
import com.store.util.AuthUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 查改
 * @Author huangzewei
 * @Date 2020-04-04
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;
    /**
     * 查询订单详情
     *
     * @param orderCode
     * @return AppResponse
     */
    @PostMapping("/findOrderDetail")
    public AppResponse findOrderDetail(String orderCode){
        try{
            return orderService.findOrderDetail(orderCode);
        }catch (Exception e){
            logger.error("订单查询错误",e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 订单列表(分页)
     *
     * @param orderList
     * @return AppResponse
     */
    @RequestMapping("/listOrders")
    public AppResponse listOrders(OrderList orderList) {
        try {
            return orderService.listOrders(orderList);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
    /**
     * 修改订单状态
     *
     * @param orderList
     * @return AppResponse
     */
    @PostMapping("/updateOrderStatus")
    public AppResponse updateOrderStatus(OrderList orderList) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            orderList.setUpdateUser(userId);
            return orderService.updateOrderStatus(orderList);
        } catch (Exception e) {
            logger.error("修改订单状态信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
