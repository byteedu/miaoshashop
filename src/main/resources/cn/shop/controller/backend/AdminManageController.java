package cn.shop.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.shop.biz.IAdminService;
import cn.shop.biz.IUserService;
import cn.shop.entity.Admin;
import cn.shop.entity.User;
import cn.shop.util.Const;
import cn.shop.util.ServerResponse;

import javax.servlet.http.HttpSession;

/**
 * Created by geely
 */

@Controller
@RequestMapping("/manage/admin")
public class AdminManageController {

    @Autowired
    private IAdminService iAdminService;

    @RequestMapping(value="login.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<Admin> login(String username, String password, HttpSession session){
        ServerResponse<Admin> response = iAdminService.login(username,password);
        if(response.isSuccess()){
            Admin admin = response.getData();   
                //说明登录的是管理员
                session.setAttribute(Const.CURRENT_ADMIN,admin);
                return response;
          
        }
        return response;
    }

}
