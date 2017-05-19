package cn.shop.biz;

import java.util.List;
import java.util.Map;

import cn.shop.entity.Informations;
import cn.shop.util.PageBean;

public interface InformationsBiz {
	public List<Informations> getInformations(PageBean pageBean);
	public Integer getCount();
	public Informations getInformationById(Integer id);
	public void updateInformations(Informations informations);
}
