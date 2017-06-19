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

import com.basic.person.model.UserCategory;
import com.basic.person.service.IUserCategoryService;

@Controller
@RequestMapping("userCategory")
public class UserCategoryController {

	@Autowired
	IUserCategoryService userCategoryService; 
	
	
	@RequestMapping("getList.json")
	@ResponseBody
	public Object getList(){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("id", -1);
		return userCategoryService.list(map);
	}
	
	@RequestMapping("getTreeList.json")
	@ResponseBody
	public Object geTreeList(@RequestParam(required=false) Integer nodeid,@RequestParam(required=false) Integer n_level){
		return userCategoryService.getTreeGrid(nodeid,n_level);
		
	}
	
	@RequestMapping("addView.view")
	public Object addView(@RequestParam int parentId,HttpServletRequest request){
		request.setAttribute("parentId", parentId);
		return "/user/category/add";
	}
	
	@RequestMapping("add.json")
	@ResponseBody
	public Object add(@ModelAttribute UserCategory userCategory){
		userCategory.setCreateTime("2015-01-01 12:12:12");
		userCategoryService.insert(userCategory);
		return userCategory;
	}
	
	@RequestMapping("updateView.view")
	public Object updateView(@RequestParam int id,HttpServletRequest request){
		request.setAttribute("userCategory", userCategoryService.selectByPrimaryKey(id));
		return "/user/category/update";
	}
	
	@RequestMapping("update.json")
	@ResponseBody
	public Object update(@ModelAttribute UserCategory userCategory){
		userCategory.setCreateTime("2015-01-01 12:12:12");
		userCategoryService.updateByPrimaryKeySelective(userCategory);
		return userCategory;
	}
	
}
