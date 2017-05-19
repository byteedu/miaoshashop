package cn.shop.controller.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.shop.biz.IFileService;
import cn.shop.biz.IGoodsService;
import cn.shop.biz.IUserService;
import cn.shop.entity.Goods;
import cn.shop.entity.User;
import cn.shop.util.Const;
import cn.shop.util.ResponseCode;
import cn.shop.util.ServerResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by geely
 */

@Controller
@RequestMapping("/manage/goods")
public class GoodsManageController {

	@Autowired
	private IUserService iUserService;
	@Autowired
	private IGoodsService iGoodsService;
	@Autowired
	private IFileService iFileService;

	@RequestMapping("save.do")
	@ResponseBody
	public ServerResponse goodsSave(HttpSession session, Goods goods) {
		User user = (User) session.getAttribute(Const.CURRENT_ADMIN);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");

		}
		return iGoodsService.saveOrUpdateGoods(goods);

	}

	@RequestMapping("detail.do")
	@ResponseBody
	public ServerResponse getDetail(HttpSession session, Integer goodsId) {
		User user = (User) session.getAttribute(Const.CURRENT_ADMIN);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");

		}
		return iGoodsService.getGoodsDetail(goodsId);
	}

	@RequestMapping("list.do")
	@ResponseBody
	public ServerResponse getList(HttpSession session, Integer categoryId) {
		User user = (User) session.getAttribute(Const.CURRENT_ADMIN);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");

		}

		return iGoodsService.getGoodsList(categoryId);

	}

	@RequestMapping("upload.do")
	@ResponseBody
	public ServerResponse upload(
			HttpSession session,
			@RequestParam(value = "upload_file", required = false) MultipartFile file,
			HttpServletRequest request) {
		User user = (User) session.getAttribute(Const.CURRENT_ADMIN);
		if (user == null) {
			return ServerResponse.createByErrorCodeMessage(
					ResponseCode.NEED_LOGIN.getCode(), "用户未登录,请登录管理员");
		}

		String path = request.getSession().getServletContext()
				.getRealPath("upload");
		String targetFileName = iFileService.upload(file, path);

		Map fileMap = new HashMap();
		fileMap.put("uri", targetFileName);
		return ServerResponse.createBySuccess(fileMap);
	}
	
}
