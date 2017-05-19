package cn.shop.entity;

import java.math.BigDecimal;

/**
 * Created by geely
 */
public class CartGoods {

//结合了产品和购物车的一个抽象对象

    private Integer id;
    private Integer userId;
    private Integer goodsId;
    private Integer quantity;//购物车中此商品的数量
    private String goodsName;
    private String goodsDesc;
    private String goodsPic;
    private Double goodsPrice;
    private Double goodsTotalPrice;
    private Integer goodsResnum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

	public String getGoodsDesc() {
		return goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsPic() {
		return goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Double getGoodsTotalPrice() {
		return goodsTotalPrice;
	}

	public void setGoodsTotalPrice(Double goodsTotalPrice) {
		this.goodsTotalPrice = goodsTotalPrice;
	}

	public Integer getGoodsResnum() {
		return goodsResnum;
	}

	public void setGoodsResnum(Integer goodsResnum) {
		this.goodsResnum = goodsResnum;
	}

    
}
