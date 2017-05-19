package cn.shop.entity;
/**
 * TCart entity. @author MyEclipse Persistence Tools
 */

public class Cart implements java.io.Serializable {

	// Fields

	private Integer cartId;
	private Integer cartUserId;
	private Integer cartGoodsId;
	private Integer cartQuantity;

	// Constructors

	/** default constructor */
	public Cart() {
	}

	/** minimal constructor */
	public Cart(Integer cartUserId) {
		this.cartUserId = cartUserId;
	}

	/** full constructor */
	public Cart(Integer cartUserId, Integer cartGoodsId, Integer cartQuantity) {
		this.cartUserId = cartUserId;
		this.cartGoodsId = cartGoodsId;
		this.cartQuantity = cartQuantity;
	}

	// Property accessors

	public Integer getCartId() {
		return this.cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Integer getCartUserId() {
		return this.cartUserId;
	}

	public void setCartUserId(Integer cartUserId) {
		this.cartUserId = cartUserId;
	}

	public Integer getCartGoodsId() {
		return this.cartGoodsId;
	}

	public void setCartGoodsId(Integer cartGoodsId) {
		this.cartGoodsId = cartGoodsId;
	}

	public Integer getCartQuantity() {
		return this.cartQuantity;
	}

	public void setCartQuantity(Integer cartQuantity) {
		this.cartQuantity = cartQuantity;
	}

}