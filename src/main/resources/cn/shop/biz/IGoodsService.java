package cn.shop.biz;

import cn.shop.entity.Goods;
import cn.shop.util.ServerResponse;

/**
 * Created by geely
 */
public interface IGoodsService {

    ServerResponse saveOrUpdateGoods(Goods goods);

    ServerResponse<Goods> getGoodsList(int categoryId);

    ServerResponse<Goods> getGoodsDetail(Integer goodsId);


}
