package cn.shop.dao;
import cn.shop.entity.Order;

import java.util.List;

public interface OrderDao {
	Order selectByPrimaryKey(Integer id);
	
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int updateByPrimaryKeySelective(Order record);

    List<Order> selectByUserId(Integer userId);

    List<Order> selectAllOrder();
}