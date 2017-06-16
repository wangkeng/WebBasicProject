package com.dubbo.person.dao;

import java.util.List;
import java.util.Map;

import com.dubbo.common.base.dao.IBaseDao;
import com.dubbo.person.model.UserCategory;
import com.dubbo.person.model.UserCategoryQueryModel;


public interface IUserCategoryDao extends IBaseDao<UserCategory,UserCategoryQueryModel>{

	List<Map<String, Object>> list(Map<String,Object> map);
	
	List<Map<String,Object>> getTreeGrid(Map<String,Object> map);

}
