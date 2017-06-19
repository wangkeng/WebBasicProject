package com.basic.person.dao;

import java.util.List;
import java.util.Map;

import com.basic.common.base.dao.IBaseDao;
import com.basic.person.model.UserCategory;
import com.basic.person.model.UserCategoryQueryModel;


public interface IUserCategoryDao extends IBaseDao<UserCategory,UserCategoryQueryModel>{

	List<Map<String, Object>> list(Map<String,Object> map);
	
	List<Map<String,Object>> getTreeGrid(Map<String,Object> map);

}
