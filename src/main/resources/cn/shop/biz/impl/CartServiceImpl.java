package cn.shop.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shop.biz.ICartService;
import cn.shop.dao.CartDao;
import cn.shop.dao.GoodsDao;
import cn.shop.entity.Cart;
import cn.shop.util.ResponseCode;
import cn.shop.util.ServerResponse;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by geely
 */
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
        Cart cart = cartDao.selectCartByUserIdProductId(userId,cartGoodsId);
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

    public ServerResponse<Cart> update(Integer userId,Integer productId,Integer count){
        if(productId == null || count == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(),ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        }
        Cart cart = cartDao.selectCartByUserIdProductId(userId,productId);
        if(cart != null){
            cart.setCartQuantity(count);
        }
        cartDao.updateByPrimaryKey(cart);
        return this.list(userId);
    }

    public ServerResponse<Cart> deleteProduct(Integer userId,String productId){
        cartDao.deleteByUserIdProductIds(userId,productId);
        return this.list(userId);
    }


    public ServerResponse<Cart> list (Integer userId){
    	Cart cartVo = this.getCartLimit(userId);
        return ServerResponse.createBySuccess(cartVo);
    }



    public ServerResponse<Cart> selectOrUnSelect (Integer userId,Integer productId,Integer checked){
        cartDao.checkedOrUncheckedProduct(userId,productId,checked);
        return this.list(userId);
    }

    public ServerResponse<Integer> getCartProductCount(Integer userId){
        if(userId == null){
            return ServerResponse.createBySuccess(0);
        }
        return ServerResponse.createBySuccess(cartDao.selectCartProductCount(userId));
    }















    private Cart getCartLimit(Integer userId){
        Cart cartVo = new Cart();
        List<Cart> cartList = cartDao.selectCartByUserId(userId);
        List<CartProductVo> cartProductVoList = Lists.newArrayList();

        BigDecimal cartTotalPrice = new BigDecimal("0");

        if(CollectionUtils.isNotEmpty(cartList)){
            for(Cart cartItem : cartList){
                CartProductVo cartProductVo = new CartProductVo();
                cartProductVo.setId(cartItem.getId());
                cartProductVo.setUserId(userId);
                cartProductVo.setProductId(cartItem.getProductId());

                Product product = productMapper.selectByPrimaryKey(cartItem.getProductId());
                if(product != null){
                    cartProductVo.setProductMainImage(product.getMainImage());
                    cartProductVo.setProductName(product.getName());
                    cartProductVo.setProductSubtitle(product.getSubtitle());
                    cartProductVo.setProductStatus(product.getStatus());
                    cartProductVo.setProductPrice(product.getPrice());
                    cartProductVo.setProductStock(product.getStock());
                    //判断库存
                    int buyLimitCount = 0;
                    if(product.getStock() >= cartItem.getQuantity()){
                        //库存充足的时候
                        buyLimitCount = cartItem.getQuantity();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_SUCCESS);
                    }else{
                        buyLimitCount = product.getStock();
                        cartProductVo.setLimitQuantity(Const.Cart.LIMIT_NUM_FAIL);
                        //购物车中更新有效库存
                        Cart cartForQuantity = new Cart();
                        cartForQuantity.setId(cartItem.getId());
                        cartForQuantity.setQuantity(buyLimitCount);
                        cartDao.updateByPrimaryKeySelective(cartForQuantity);
                    }
                    cartProductVo.setQuantity(buyLimitCount);
                    //计算总价
                    cartProductVo.setProductTotalPrice(BigDecimalUtil.mul(product.getPrice().doubleValue(),cartProductVo.getQuantity()));
                    cartProductVo.setProductChecked(cartItem.getChecked());
                }

                if(cartItem.getChecked() == Const.Cart.CHECKED){
                    //如果已经勾选,增加到整个的购物车总价中
                    cartTotalPrice = BigDecimalUtil.add(cartTotalPrice.doubleValue(),cartProductVo.getProductTotalPrice().doubleValue());
                }
                cartProductVoList.add(cartProductVo);
            }
        }
        cartVo.setCartTotalPrice(cartTotalPrice);
        cartVo.setCartProductVoList(cartProductVoList);
        cartVo.setAllChecked(this.getAllCheckedStatus(userId));
        cartVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix"));

        return cartVo;
    }

    private boolean getAllCheckedStatus(Integer userId){
        if(userId == null){
            return false;
        }
        return cartDao.selectCartProductCheckedStatusByUserId(userId) == 0;

    }


























}
