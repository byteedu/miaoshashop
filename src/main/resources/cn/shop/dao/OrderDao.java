package cn.shop.dao;
import cn.shop.entity.Order;

import java.util.List;

public interface OrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int updateByPrimaryKeySelective(Order record);

    Order selectByOrderNo(String orderNo);

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllOrder();
}