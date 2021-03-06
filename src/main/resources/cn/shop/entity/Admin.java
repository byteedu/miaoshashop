package cn.shop.entity;

/**
 * TAdmin entity. @author MyEclipse Persistence Tools
 */

public class Admin implements java.io.Serializable {

	// Fields

	private Integer userId;
	private String userName;
	private String userPw;

	// Constructors

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String userName, String userPw) {
		this.userName = userName;
		this.userPw = userPw;
	}

	// Property accessors

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPw() {
		return this.userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

}