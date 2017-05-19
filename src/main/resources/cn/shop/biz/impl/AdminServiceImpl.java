package cn.shop.biz.impl;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.shop.biz.IAdminService;
import cn.shop.biz.IUserService;
import cn.shop.dao.AdminDao;
import cn.shop.dao.UserDao;
import cn.shop.entity.Admin;
import cn.shop.entity.User;
import cn.shop.util.Const;
import cn.shop.util.ServerResponse;
/**
 * Created by geely
 */
@Service("iUserService")
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminDao adminDao;

	public ServerResponse<Admin> login(String username, String password) {
		Admin admin = adminDao.selectLogin(username, password);
		if (admin == null) {
			return ServerResponse.createByErrorMessage("用户名密码错误");
		}
		return ServerResponse.createBySuccess("登录成功", admin);
	}


	public ServerResponse updatePasswordByUsername(String userName, String userPwNew){
		// username是不能被更新的
		// email也要进行一个校验,校验新的email是不是已经存在,并且存在的email如果相同的话,不能是我们当前的这个用户的.

		int updateCount = adminDao.updatePasswordByUsername(userName,userPwNew);
		if (updateCount > 0) {
			return ServerResponse.createBySuccess("更新个人信息成功", updateCount);
		}
		return ServerResponse.createByErrorMessage("更新个人信息失败");
	}
	

}
