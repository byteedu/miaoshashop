package cn.shop.biz;

import cn.shop.entity.Admin;
import cn.shop.entity.User;
import cn.shop.util.ServerResponse;

/**
 * Created by geely
 */
public interface IAdminService {

	ServerResponse<Admin> login(String username, String password);


    ServerResponse updatePasswordByUsername(String username, String password);


}
