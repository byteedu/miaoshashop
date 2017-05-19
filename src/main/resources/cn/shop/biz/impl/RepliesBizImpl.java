package cn.shop.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shop.dao.RepliesDao;
import cn.shop.entity.Replies;
import cn.shop.biz.RepliesBiz;
@Service
public class RepliesBizImpl implements RepliesBiz{
	@Autowired
	RepliesDao repliesDao=null;

	public List<Replies> getRepliesByInfoid(Integer infoid) {
		// TODO �Զ���ɵķ������
		return repliesDao.getRepliesByInfoid(infoid);
	}


	public void addReplies(Replies replies) {
		// TODO �Զ���ɵķ������
		repliesDao.addReplies(replies);
	}

	public void setRepliesDao(RepliesDao repliesDao) {
		this.repliesDao = repliesDao;
	}

}
