package cn.shop.entity;

/**
 * TOrderitem entity. @author MyEclipse Persistence Tools
 */

public class OrderItem implements java.io.Serializable {

	// Fields

	private Integer orderItemId;
	private Integer orderId;
	private Integer goodsId;
	private Integer goodsQuantity;

	// Constructors

	/** default constructor */
	public OrderItem() {
	}

	/** full constructor */
	public OrderItem(Integer orderId, Integer goodsId, Integer goodsQuantity) {
		this.orderId = orderId;
		this.goodsId = goodsId;
		this.goodsQuantity = goodsQuantity;
	}

	// Property accessors

	public Integer getOrderItemId() {
		return this.orderItemId;
	}

	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getGoodsQuantity() {
		return this.goodsQuantity;
	}

	public void setGoodsQuantity(Integer goodsQuantity) {
		this.goodsQuantity = goodsQuantity;
	}

}