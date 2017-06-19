package com.basic.person.daoImpl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.basic.common.base.daoImpl.BaseDaoImpl;
import com.basic.person.dao.IUserCategoryDao;
import com.basic.person.model.UserCategory;
import com.basic.person.model.UserCategoryQueryModel;
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
