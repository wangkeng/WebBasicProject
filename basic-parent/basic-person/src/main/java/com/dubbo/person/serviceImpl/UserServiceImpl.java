package com.dubbo.person.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dubbo.common.base.serviceImpl.BaseServiceImpl;
import com.dubbo.person.dao.IUserDao;
import com.dubbo.person.model.User;
import com.dubbo.person.model.UserQueryModel;
import com.dubbo.person.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,UserQueryModel> implements IUserService{

	private IUserDao userDao = null ;

	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setBaseDao(userDao);
	}
	
}
