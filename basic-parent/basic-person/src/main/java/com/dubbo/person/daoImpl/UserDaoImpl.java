package com.dubbo.person.daoImpl;

import org.springframework.stereotype.Repository;

import com.dubbo.common.base.daoImpl.BaseDaoImpl;
import com.dubbo.person.dao.IUserDao;
import com.dubbo.person.model.User;
import com.dubbo.person.model.UserQueryModel;
@Repository
public class UserDaoImpl extends BaseDaoImpl<IUserDao,User,UserQueryModel> implements IUserDao{


	

}
