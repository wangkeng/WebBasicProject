package com.basic.person.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.common.base.serviceImpl.BaseServiceImpl;
import com.basic.person.dao.IUserDao;
import com.basic.person.model.User;
import com.basic.person.model.UserQueryModel;
import com.basic.person.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,UserQueryModel> implements IUserService{

	private IUserDao userDao = null ;

	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setBaseDao(userDao);
	}
	
}
