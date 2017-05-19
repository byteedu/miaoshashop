package cn.shop.dao;

import java.util.List;

import cn.shop.entity.Replies;

public interface RepliesDao {
	public List<Replies> getRepliesByInfoid(Integer infoid);
	public void addReplies(Replies replies);
}
