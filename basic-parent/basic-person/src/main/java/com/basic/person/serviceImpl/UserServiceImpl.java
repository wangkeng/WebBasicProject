package com.basic.person.serviceImpl;

import org.redisson.api.RMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.basic.common.base.serviceImpl.BaseServiceImpl;
import com.basic.common.utils.redis.RCollectionConvert;
import com.basic.common.utils.redis.RedissonUtils;
import com.basic.person.dao.IUserDao;
import com.basic.person.model.User;
import com.basic.person.model.UserQueryModel;
import com.basic.person.service.IUserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User,UserQueryModel> implements IUserService{

	private IUserDao userDao = null ;
	@Autowired
	private RedissonUtils redissonUtils;
	@Autowired
	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
		super.setBaseDao(userDao); 
	}
	
	@Override
	public User selectByPrimaryKey(Integer id) throws Exception {
		User user = null ;
		RMap<String, Object> map = redissonUtils.getRMap("user:"+id);
		if(!map.isEmpty()){
			user = RCollectionConvert.mMapToObj(map,User.class);
			return user;
		}
		user = userDao.selectByPrimaryKey(id);
		redissonUtils.setMap("user:"+id,user);
		return user;
	}
	
}
