package cn.shop.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shop.entity.Informations;
import cn.shop.entity.Replies;
import cn.shop.util.PageBean;
import cn.shop.biz.InformationsBiz;
import cn.shop.biz.RepliesBiz;

@Controller
public class InfoController {
	@Autowired
	private InformationsBiz informationsBiz;
	@Autowired
	private RepliesBiz repliesBiz;
	private PageBean pageBean=new PageBean();
	@RequestMapping("/listInfos")
	public String listInfos(int pageNo,HttpSession session){
		pageBean.setPageNo(pageNo);
		pageBean.setTotalCount(informationsBiz.getCount());
		List<Informations> informations=informationsBiz.getInformations(pageBean);
		session.setAttribute("pageBean", pageBean);
		session.setAttribute("informations", informations);
		return "list";
	}
	@RequestMapping("/getInfo")
	public String getInfo(int id,HttpSession session){
		Informations info=informationsBiz.getInformationById(id);
		//�鿴�����1
		info.setViewcount(info.getViewcount()+1);
		informationsBiz.updateInformations(info);
		
		session.setAttribute("info", info);
		List<Replies> replies=repliesBiz.getRepliesByInfoid(id);
		session.setAttribute("replies", replies);
		return "show";
	}
	
	@RequestMapping("/addReply")
	@ResponseBody
	public List<Replies> addReply(String content,int infoid){
		List<Replies> replies=new ArrayList<Replies>();
		//����һ������
		Replies reply=new Replies();
		//��������
		reply.setReplytime(new Date());
		reply.setContent(content);
		reply.setInfoid(infoid);
		
		repliesBiz.addReplies(reply);
		//�ظ������1
		Informations info=informationsBiz.getInformationById(infoid);
		info.setReplycount(info.getReplycount()+1);
		info.setLastposttime(new Date());
		informationsBiz.updateInformations(info);
		
		//�������ѯ
		replies=repliesBiz.getRepliesByInfoid(infoid);
		
		return replies;
	}
	
}
