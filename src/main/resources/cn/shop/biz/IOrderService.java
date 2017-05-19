package cn.shop.biz;

import java.util.Map;

import cn.shop.entity.Order;
import cn.shop.util.ServerResponse;

/**
 * Created by geely
 */
public interface IOrderService {
//    ServerResponse createOrder(Integer userId,Integer shippingId);
//    ServerResponse<String> cancel(Integer userId,Long orderNo);
//    ServerResponse getOrderCartProduct(Integer userId);
//    ServerResponse<Order> getOrderDetail(Integer userId, Long orderNo);
	ServerResponse getOrderList();
    ServerResponse getOrderListByUserId(Integer userId);

    //backend
    //ServerResponse<PageInfo> manageList(int pageNum,int pageSize);
//    ServerResponse<Order> manageDetail(Long orderNo);
   // ServerResponse<PageInfo> manageSearch(Long orderNo,int pageNum,int pageSize);
//    ServerResponse<String> manageSendGoods(Long orderNo);


}
