package com.basic.person.daoImpl;

import org.springframework.stereotype.Repository;

import com.basic.common.base.daoImpl.BaseDaoImpl;
import com.basic.person.dao.IUserDao;
import com.basic.person.model.User;
import com.basic.person.model.UserQueryModel;
@Repository
public class UserDaoImpl extends BaseDaoImpl<IUserDao,User,UserQueryModel> implements IUserDao{


	

}
