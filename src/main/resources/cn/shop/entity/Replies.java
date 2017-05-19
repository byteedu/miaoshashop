package cn.shop.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Replies implements Serializable {
	private Integer id;
	private String content;
	private Date replytime;
	private Integer infoid;

	private String rtime;
	private String ltime;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String getRtime() {

		return format.format(getReplytime());
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReplytime() {
		return replytime;
	}

	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}

	public Integer getInfoid() {
		return infoid;
	}

	public void setInfoid(Integer infoid) {
		this.infoid = infoid;
	}
}
