package com.basic.person.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.basic.common.base.controller.BaseController;
import com.basic.person.model.User;
import com.basic.person.model.UserQueryModel;
import com.basic.person.service.IUserService;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("user")
public class UserController extends BaseController{

	@Autowired
	IUserService userService ;
	/*@Value("${3gtvUrl}")
	private String path ;*/
	
	@RequestMapping("getList.json")
	@ResponseBody
	public Object getList(@ModelAttribute UserQueryModel userQuery,
			HttpServletRequest request){
		PageInfo<User> pageInfo = userService.getListPage(userQuery);
		request.setAttribute("userQuery", userQuery);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("total", pageInfo.getTotal());
		map.put("rows", pageInfo.getList());
		return map;
	}
	
	@RequestMapping("add.json")
	@ResponseBody
	public Object add(@ModelAttribute User user){
		userService.insert(user);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", 200);
		map.put("message", "保存成功");
		return map;
	}
	
	@RequestMapping("update.json")
	@ResponseBody
	public Object update(@ModelAttribute User user){
		userService.updateByPrimaryKeySelective(user);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", 200);
		map.put("message", "修改成功");
		return map;
	}
	
	@RequestMapping("update.view")
	public Object updateView(@RequestParam int id,HttpServletRequest request){
		User user = userService.selectByPrimaryKey(id);
		request.setAttribute("user", user);
		return "user/update";
	}
	
	@RequestMapping("deleteById.json")
	@ResponseBody
	public Object deleteById(@RequestParam int id){
		userService.deleteByPrimaryKey(id);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", 200);
		map.put("message", "删除成功");
		return map;
	}
	
	@RequestMapping("deleteBatch.json")
	@ResponseBody
	public Object deleteBatch(@RequestParam String ids){
		
		userService.deleteBatch(ids);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("status", 200);
		map.put("message", "删除成功");
		return map;
	}
}
