package cn.shop.biz;

import cn.shop.entity.Goods;
import cn.shop.util.ServerResponse;

/**
 * Created by geely
 */
public interface IGoodsService {

    ServerResponse saveOrUpdateGoods(Goods product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    ServerResponse<Goods> manageGoodsDetail(Integer productId);

    ServerResponse<Goods> getGoodsList(int pageNum, int pageSize);

    ServerResponse<Goods> searchGoods(String productName,Integer productId,int pageNum,int pageSize);

    ServerResponse<Goods> getGoodsDetail(Integer productId);

    ServerResponse<Goods> getGoodsByKeywordCategory(String keyword,Integer categoryId,int pageNum,int pageSize,String orderBy);



}
