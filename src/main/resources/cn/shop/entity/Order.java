package cn.shop.entity;

/**
 * TOrder entity. @author MyEclipse Persistence Tools
 */

public class Order implements java.io.Serializable {

	// Fields

	private Integer orderId;
	private String orderNo;
	private String orderDate;
	private Integer orderAddressId;
	private Integer orderPrice;
	private Integer orderUserId;

	// Constructors

	/** default constructor */
	public Order() {
	}

	/** full constructor */
	public Order(String orderNo, String orderDate, Integer orderAddressId,
			Integer orderPrice, Integer orderUserId) {
		this.orderNo = orderNo;
		this.orderDate = orderDate;
		this.orderAddressId = orderAddressId;
		this.orderPrice = orderPrice;
		this.orderUserId = orderUserId;
	}

	// Property accessors

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getOrderNo() {
		return this.orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderDate() {
		return this.orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getOrderAddressId() {
		return this.orderAddressId;
	}

	public void setOrderAddressId(Integer orderAddressId) {
		this.orderAddressId = orderAddressId;
	}

	public Integer getOrderPrice() {
		return this.orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public Integer getOrderUserId() {
		return this.orderUserId;
	}

	public void setOrderUserId(Integer orderUserId) {
		this.orderUserId = orderUserId;
	}

}