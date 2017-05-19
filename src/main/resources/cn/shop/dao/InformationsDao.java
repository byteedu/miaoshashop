package cn.shop.dao;

import java.util.List;
import java.util.Map;

import cn.shop.entity.Informations;

public interface InformationsDao {
	public List<Informations> getInformations(Map<String,Object> params);
	public Integer getCount();
	public Informations getInformationById(Integer id);
	public void updateInformations(Informations informations);
}
