package com.store.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.store.order.dao.OrderDao;
import com.store.order.entity.OrderDetail;
import com.store.order.entity.OrderList;
import com.store.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description 实现类
 * @Author huangzewei
 * @Date 2020-04-04
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    /**
     * order 查询订单详情
     *
     * @param orderCode
     * @return
     * @Author huangzewei
     * @Date 2020-04-04
     */
    public AppResponse findOrderDetail(String orderCode){
        OrderDetail orderDetail = orderDao.findOrderDetail(orderCode);
        if(orderDetail != null){
            return AppResponse.success("查询成功",orderDetail);
        }else {
            return AppResponse.bizError("查询失败");
        }
    }
    /**
     * 查询订单列表（分页）
     *
     * @param orderList
     * @return
     */
    public AppResponse listOrders(OrderList orderList) {
        PageHelper.startPage(orderList.getPageNum(), orderList.getPageSize());
        List<OrderList> orderInfoList = orderDao.listOrdersByPage(orderList);
        // 包装Page对象
        PageInfo<OrderList> pageData = new PageInfo<OrderList>(orderInfoList);
        if(pageData!=null){
            return AppResponse.success("查询成功！", pageData);
        }else{
            return AppResponse.bizError("查询失败，请重试！");
        }
    }
    /**
     * 修改订单状态
     *
     * @param orderList
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderList orderList) {
        // 修改订单信息
        int count = orderDao.updateOrderStatus(orderList);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }else{
            return AppResponse.success("修改成功");
        }
    }
}
