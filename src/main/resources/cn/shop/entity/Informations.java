package cn.shop.entity;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Informations implements Serializable {
	private Integer id;
	private String title;
	private String content;
	private Integer replycount;
	private Integer viewcount;
	private Date reporttime;
	private Date lastposttime;
	private String rtime;
	private String ltime;

	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public String getRtime() {

		return format.format(getReporttime());
	}

	public void setRtime(String rtime) {
		this.rtime = rtime;
	}

	public String getLtime() {
		return format.format(getLastposttime());
	}

	public void setLtime(String ltime) {
		this.ltime = ltime;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getReplycount() {
		return replycount;
	}

	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}

	public Integer getViewcount() {
		return viewcount;
	}

	public void setViewcount(Integer viewcount) {
		this.viewcount = viewcount;
	}

	public Date getReporttime() {
		return reporttime;
	}

	public void setReporttime(Date reporttime) {
		this.reporttime = reporttime;
	}

	public Date getLastposttime() {
		return lastposttime;
	}

	public void setLastposttime(Date lastposttime) {
		this.lastposttime = lastposttime;
	}

}
