package cn.shop.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shop.biz.ICartService;
import cn.shop.dao.CartDao;
import cn.shop.dao.GoodsDao;
import cn.shop.entity.Cart;
import cn.shop.entity.CartGoods;
import cn.shop.entity.Goods;
import cn.shop.util.ResponseCode;
import cn.shop.util.ServerResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("iCartService")
public class CartServiceImpl implements ICartService {

    @Autowired
    private CartDao cartDao;
    @Autowired
    private GoodsDao goodsDao;

    public ServerResponse<Cart> add(Integer userId,Integer cartGoodsId,Integer count){
        if(cartGoodsId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartDao.selectCartByUserIdGoodsId(userId,cartGoodsId);
        if(cart == null){
            //这个产品不在这个购物车里,需要新增一个这个产品的记录
            Cart cartItem = new Cart();
            cartItem.setCartQuantity(count);
            cartItem.setCartGoodsId(cartGoodsId);
            cartItem.setCartUserId(userId);
            cartDao.insert(cartItem);
        }else{
            //这个产品已经在购物车里了.
            //如果产品已存在,数量相加
            count = cart.getCartQuantity() + count;
            cart.setCartQuantity(count);
            cartDao.updateByPrimaryKeySelective(cart);
        }
        return this.list(userId);
    }

    public ServerResponse<Cart> update(Integer userId,Integer goodsId,Integer count){
        if(goodsId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartDao.selectCartByUserIdGoodsId(userId, goodsId);
        if(cart != null){
            cart.setCartQuantity(count);
        }
        cartDao.updateByPrimaryKeySelective(cart);
        return this.list(userId);
    }

    public ServerResponse<Cart> deleteGoods(Integer userId,Integer goodsId){
        cartDao.deleteByUserIdGoodsId(userId,goodsId);
        return this.list(userId);
    }


    public ServerResponse<Cart> list (Integer userId){
    	Cart cartVo = this.getCartLimit(userId);
        return ServerResponse.createBySuccess(cartVo);
    }

    private Cart getCartLimit(Integer userId){
        Cart cartVo = new Cart();
        List<Cart> cartList = cartDao.selectCartByUserId(userId);
        List<CartGoods> cartGoodsVoList = new ArrayList<CartGoods>();

        BigDecimal cartTotalPrice = new BigDecimal("0");

        if(!cartGoodsVoList.isEmpty()){
            for(Cart cartItem : cartList){
                CartGoods cartGoodsVo = new CartGoods();
                cartGoodsVo.setId(cartItem.getCartId());
                cartGoodsVo.setUserId(userId);
                cartGoodsVo.setGoodsId(cartItem.getCartGoodsId());

                Goods goods = goodsDao.selectByPrimaryKey(cartItem.getCartGoodsId());
                if(goods != null){
                    cartGoodsVo.setGoodsPic(goods.getGoodsPic());
                    cartGoodsVo.setGoodsName(goods.getGoodsName());
                    cartGoodsVo.setGoodsDesc(goods.getGoodsDesc());
                    cartGoodsVo.setGoodsPrice(goods.getGoodsPrice());
                    cartGoodsVo.setGoodsResnum(goods.getGoodsResnum());
//                    //判断库存
//                    int buyLimitCount = 0;
//                    if(goods.getGoodsResnum() >= cartItem.getCartQuantity()){
//                        //库存充足的时候
//                        buyLimitCount = cartItem.getQuantity();
//                        cartGoodsVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
//                    }else{
//                        buyLimitCount = goods.getStock();
//                        cartGoodsVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
//                        //购物车中更新有效库存
//                        Cart cartForQuantity = new Cart();
//                        cartForQuantity.setId(cartItem.getId());
//                        cartForQuantity.setQuantity(buyLimitCount);
//                        cartDao.updateByPrimaryKeySelective(cartForQuantity);
//                    }
//                    cartGoodsVo.setQuantity(buyLimitCount);
//                    //计算总价
//                    cartGoodsVo.setGoodsTotalPrice(BigDecimalUtil.mul(goods.getPrice().doubleValue(),cartGoodsVo.getQuantity()));
//                    cartGoodsVo.setGoodsChecked(cartItem.getChecked());
//                }
//
//                if(cartItem.getChecked() == Const.Cart.CHECKED){
//                    //如果已经勾选,增加到整个的购物车总价中
//                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartGoodsVo.getGoodsTotalPrice().doubleValue());
//                }
                cartGoodsVoList.add(cartGoodsVo);
            }
        }
//        cartVo.setCartTotalPrice(cartTotalPrice);
//        cartVo.setCartGoodsVoList(cartGoodsVoList);

        return cartVo;
    }

}

