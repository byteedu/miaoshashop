package cn.shop.biz;

import cn.shop.entity.Cart;
import cn.shop.util.ServerResponse;

/**
 * Created by geely
 */
public interface ICartService {
    ServerResponse<Cart> add(Integer userId, Integer productId, Integer count);
    ServerResponse<Cart> update(Integer userId,Integer productId,Integer count);
    ServerResponse<Cart> deleteProduct(Integer userId,String productIds);

    ServerResponse<Cart> list (Integer userId);
    ServerResponse<Cart> selectOrUnSelect (Integer userId,Integer productId,Integer checked);
    ServerResponse<Integer> getCartProductCount(Integer userId);
}
