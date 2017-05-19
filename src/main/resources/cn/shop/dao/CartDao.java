package cn.shop.dao;

import org.apache.ibatis.annotations.Param;

import cn.shop.entity.Cart;

import java.util.List;

public interface CartDao {
	int deleteByUserIdGoodsId(@Param("userId") Integer userId,@Param("goodsId")Integer goodsId);
    int insert(Cart record);
    int updateByPrimaryKeySelective(Cart record);
    Cart selectCartByUserIdGoodsId(@Param("userId") Integer userId, @Param("goodsId")Integer goodsId);
    List<Cart> selectCartByUserId(Integer userId);
    List<Cart> selectCart();
}