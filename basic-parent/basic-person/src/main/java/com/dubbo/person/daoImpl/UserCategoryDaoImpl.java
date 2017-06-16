package com.dubbo.person.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.dubbo.common.base.daoImpl.BaseDaoImpl;
import com.dubbo.person.dao.IUserCategoryDao;
import com.dubbo.person.model.UserCategory;
import com.dubbo.person.model.UserCategoryQueryModel;
@Repository
public class UserCategoryDaoImpl extends BaseDaoImpl<IUserCategoryDao,UserCategory,UserCategoryQueryModel> implements IUserCategoryDao{


	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return getMapper().list(map);
	}

	@Override
	public List<Map<String, Object>> getTreeGrid(Map<String, Object> map) {
		return getMapper().getTreeGrid(map);
	}


/*	public List<Map<String,Object>> list(Map<String,Object> map) {
		return getMapper().list(map);
	}

	@Override
	public List<Map<String, Object>> getTreeGrid(Map<String, Object> map) {
		return getMapper().getTreeGrid(map);
	}
*/
}
