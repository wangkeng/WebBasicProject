package com.dubbo.person.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dubbo.common.base.serviceImpl.BaseServiceImpl;
import com.dubbo.person.dao.IUserCategoryDao;
import com.dubbo.person.model.UserCategory;
import com.dubbo.person.model.UserCategoryQueryModel;
import com.dubbo.person.service.IUserCategoryService;

@Service("userCategoryService")
public class UserCategoryServiceImpl extends BaseServiceImpl<UserCategory,UserCategoryQueryModel> implements IUserCategoryService{

	private IUserCategoryDao userCategoryDao = null ;
	/*@Autowired
	RedissonUtils redissonUtils;*/
	
	@Autowired
	public void setUserCategoryDao(IUserCategoryDao userCategoryDao) {
		this.userCategoryDao = userCategoryDao;
		super.setBaseDao(userCategoryDao);
	}
	
	@Override
	public List<Map<String, Object>> getTreeGrid(Integer nodeId,Integer n_level) {
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(nodeId == null){
			map.put("id", -1);
		}else{
			map.put("id", nodeId);
		}
		if(n_level == null){
			map.put("level", 0);
		}else{
			map.put("level", n_level+1);
		}
		
		return userCategoryDao.getTreeGrid(map);
	}



	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return userCategoryDao.list(map);
	}



}
