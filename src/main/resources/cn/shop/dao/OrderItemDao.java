package cn.shop.dao;

import org.apache.ibatis.annotations.Param;

import cn.shop.entity.OrderItem;

import java.util.List;

public interface OrderItemDao {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderItemDao record);

    int insertSelective(OrderItemDao record);

    OrderItem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderItem record);

    int updateByPrimaryKey(OrderItem record);

    List<OrderItem> getByOrderNoUserId(@Param("orderNo")Long orderNo, @Param("userId")Integer userId);

    List<OrderItem> getByOrderNo(@Param("orderNo")Long orderNo);


    /**
     * 批量插入（划重点）
     * 插入语句中，value的赋值通过foreach遍历设置
     * @param orderItemList
     */
    void batchInsert(@Param("orderItemList") List<OrderItem> orderItemList);


}