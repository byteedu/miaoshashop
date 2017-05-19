package cn.shop.biz;

import cn.shop.entity.User;
import cn.shop.util.ServerResponse;

/**
 * Created by geely
 */
public interface IUserService {

	ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<User> updateInformation(User user);

    ServerResponse<User> getInformation(Integer userId);

}
