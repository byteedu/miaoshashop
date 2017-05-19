package cn.shop.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.shop.biz.IUserService;
import cn.shop.dao.UserDao;
import cn.shop.entity.User;
import cn.shop.util.ServerResponse;
/**
 * Created by geely
 */
@Service("iUserService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private UserDao userDao;

	public ServerResponse<User> login(String username, String password) {
		User user = userDao.selectLogin(username, password);
		if (user == null) {
			return ServerResponse.createByErrorMessage("用户名密码错误");
		}
		return ServerResponse.createBySuccess("登录成功", user);
	}

	public ServerResponse<String> register(User user) {
		int resultCount = userDao.insert(user);
		if (resultCount == 0) {
			return ServerResponse.createByErrorMessage("注册失败");
		}
		return ServerResponse.createBySuccessMessage("注册成功");
	}

	public ServerResponse<User> updateInformation(User user) {
		// username是不能被更新的
		// email也要进行一个校验,校验新的email是不是已经存在,并且存在的email如果相同的话,不能是我们当前的这个用户的.

		int updateCount = userDao.updateByPrimaryKeySelective(user);
		if (updateCount > 0) {
			return ServerResponse.createBySuccess("更新个人信息成功", user);
		}
		return ServerResponse.createByErrorMessage("更新个人信息失败");
	}

	public ServerResponse<User> getInformation(Integer userId) {
		User user = userDao.selectByPrimaryKey(userId);
		if (user == null) {
			return ServerResponse.createByErrorMessage("找不到当前用户");
		}
		return ServerResponse.createBySuccess(user);

	}

}
