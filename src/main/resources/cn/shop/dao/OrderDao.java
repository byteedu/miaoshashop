package cn.shop.dao;

import org.apache.ibatis.annotations.Param;

import cn.shop.entity.Order;

import java.util.List;

public interface OrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    Order selectByUserIdAndOrderNo(@Param("userId")Integer userId,@Param("orderNo")Long orderNo);


    Order selectByOrderNo(Long orderNo);



    List<Order> selectByUserId(Integer userId);


    List<Order> selectAllOrder();
}