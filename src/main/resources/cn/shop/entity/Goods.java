package cn.shop.entity;

/**
 * TGoods entity. @author MyEclipse Persistence Tools
 */

public class Goods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private String goodsName;
	private String goodsDesc;
	private String goodsPic;
	private Double goodsPrice;
	private String goodsStarttime;
	private String goodsEndtime;
	private Integer goodsCatelogId;
	private Integer goodsInitnum;
	private Integer goodsResnum;
	private Integer goodsDel;

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** full constructor */
	public Goods(String goodsName, String goodsDesc, String goodsPic,
			Double goodsPrice, String goodsStarttime, String goodsEndtime,
			Integer goodsCatelogId, Integer goodsInitnum, Integer goodsResnum,
			Integer goodsDel) {
		this.goodsName = goodsName;
		this.goodsDesc = goodsDesc;
		this.goodsPic = goodsPic;
		this.goodsPrice = goodsPrice;
		this.goodsStarttime = goodsStarttime;
		this.goodsEndtime = goodsEndtime;
		this.goodsCatelogId = goodsCatelogId;
		this.goodsInitnum = goodsInitnum;
		this.goodsResnum = goodsResnum;
		this.goodsDel = goodsDel;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsDesc() {
		return this.goodsDesc;
	}

	public void setGoodsDesc(String goodsDesc) {
		this.goodsDesc = goodsDesc;
	}

	public String getGoodsPic() {
		return this.goodsPic;
	}

	public void setGoodsPic(String goodsPic) {
		this.goodsPic = goodsPic;
	}

	public Double getGoodsPrice() {
		return this.goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public String getGoodsStarttime() {
		return this.goodsStarttime;
	}

	public void setGoodsStarttime(String goodsStarttime) {
		this.goodsStarttime = goodsStarttime;
	}

	public String getGoodsEndtime() {
		return this.goodsEndtime;
	}

	public void setGoodsEndtime(String goodsEndtime) {
		this.goodsEndtime = goodsEndtime;
	}

	public Integer getGoodsCatelogId() {
		return this.goodsCatelogId;
	}

	public void setGoodsCatelogId(Integer goodsCatelogId) {
		this.goodsCatelogId = goodsCatelogId;
	}

	public Integer getGoodsInitnum() {
		return this.goodsInitnum;
	}

	public void setGoodsInitnum(Integer goodsInitnum) {
		this.goodsInitnum = goodsInitnum;
	}

	public Integer getGoodsResnum() {
		return this.goodsResnum;
	}

	public void setGoodsResnum(Integer goodsResnum) {
		this.goodsResnum = goodsResnum;
	}

	public Integer getGoodsDel() {
		return this.goodsDel;
	}

	public void setGoodsDel(Integer goodsDel) {
		this.goodsDel = goodsDel;
	}

}