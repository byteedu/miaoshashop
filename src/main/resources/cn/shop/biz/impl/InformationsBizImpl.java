package cn.shop.biz.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shop.dao.InformationsDao;
import cn.shop.entity.Informations;
import cn.shop.util.PageBean;
import cn.shop.biz.InformationsBiz;
@Service
public class InformationsBizImpl implements InformationsBiz{
	@Autowired
	InformationsDao informationsDao=null;
	

	public List<Informations> getInformations(PageBean pageBean) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("begin", (pageBean.getPageNo()-1)*pageBean.getPageSize());
		params.put("end", pageBean.getPageNo()*pageBean.getPageSize());
		// TODO �Զ���ɵķ������
		return informationsDao.getInformations(params);
	}


	public Integer getCount() {
		// TODO �Զ���ɵķ������
		return informationsDao.getCount();
	}


	public Informations getInformationById(Integer id) {
		// TODO �Զ���ɵķ������
		return informationsDao.getInformationById(id);
	}


	public void updateInformations(Informations informations) {
		// TODO �Զ���ɵķ������
		informationsDao.updateInformations(informations);
	}

	public void setInformationsDao(InformationsDao informationsDao) {
		this.informationsDao = informationsDao;
	}
	
}
