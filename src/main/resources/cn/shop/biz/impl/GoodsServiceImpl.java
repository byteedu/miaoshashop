package cn.shop.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import cn.shop.biz.IGoodsService;
import cn.shop.dao.GoodsDao;
import cn.shop.entity.Goods;
import cn.shop.util.ResponseCode;
import cn.shop.util.ServerResponse;

import java.util.ArrayList;
import java.util.List;

@Service("iGoodsService")
public class GoodsServiceImpl implements IGoodsService {
    @Autowired
    private GoodsDao goodsDao;

    public ServerResponse saveOrUpdateGoods(Goods goods){
        if(goods != null)
        {
            if(goods.getGoodsId() != null){
                int rowCount = goodsDao.updateByPrimaryKeySelective(goods);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("更新产品成功");
                }
                return ServerResponse.createBySuccess("更新产品失败");
            }else{
                int rowCount = goodsDao.insert(goods);
                if(rowCount > 0){
                    return ServerResponse.createBySuccess("新增产品成功");
                }
                return ServerResponse.createBySuccess("新增产品失败");
            }
        }
        return ServerResponse.createByErrorMessage("新增或更新产品参数不正确");
    }

    public ServerResponse getGoodsList(int categoryId){
        List<Goods> goodsList = goodsDao.selectByCategoryId(categoryId);
        return ServerResponse.createBySuccess(goodsList);
    }

    public ServerResponse<Goods> getGoodsDetail(Integer goodsId){
        if(goodsId == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Goods goods = goodsDao.selectByPrimaryKey(goodsId);
        if(goods == null){
            return ServerResponse.createByErrorMessage("产品已下架或者删除");
        }
        return ServerResponse.createBySuccess(goods);
    }

}
