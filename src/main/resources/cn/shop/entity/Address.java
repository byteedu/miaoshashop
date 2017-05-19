package cn.shop.entity;

/**
 * TAddress entity. @author MyEclipse Persistence Tools
 */

public class Address implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private String addressDesc;
	private Integer addressUserId;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** full constructor */
	public Address(String addressDesc, Integer addressUserId) {
		this.addressDesc = addressDesc;
		this.addressUserId = addressUserId;
	}

	// Property accessors

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressDesc() {
		return this.addressDesc;
	}

	public void setAddressDesc(String addressDesc) {
		this.addressDesc = addressDesc;
	}

	public Integer getAddressUserId() {
		return this.addressUserId;
	}

	public void setAddressUserId(Integer addressUserId) {
		this.addressUserId = addressUserId;
	}

}