package cn.shop.biz;

import java.util.List;

import cn.shop.entity.Replies;

public interface RepliesBiz {
	public List<Replies> getRepliesByInfoid(Integer infoid);
	public void addReplies(Replies replies);
}
