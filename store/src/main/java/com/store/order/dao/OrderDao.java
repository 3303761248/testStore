package com.store.order.dao;

import com.store.order.entity.OrderDetail;
import com.store.order.entity.OrderList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description Order
 * @Author huangzewei
 * @Date 2020-04-04
 */
public interface OrderDao {
    /**
     * 查询订单信息
     * @param orderCode 订单编号
     * @return
     */
    OrderDetail findOrderDetail(@Param("orderCode") String orderCode);
    /**
     * 获取所有订单信息
     * @param orderList
     * @return
     */
    List<OrderList> listOrdersByPage(OrderList orderList);
    /**
     * 修改订单状态
     * @param orderList
     * @return 修改结果
     */
    int updateOrderStatus(OrderList orderList);
}
