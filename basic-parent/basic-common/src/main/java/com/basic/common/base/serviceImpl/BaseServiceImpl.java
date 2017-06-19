package com.basic.common.base.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.basic.common.base.dao.IBaseDao;
import com.basic.common.base.model.BaseQueryParam;
import com.basic.common.base.service.IBaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
public class BaseServiceImpl<T,PojoParam> implements IBaseService<T,PojoParam> {

	IBaseDao<T,PojoParam> baseDao;

	public void setBaseDao(IBaseDao<T,PojoParam> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public int insert(T pojo) {
		return baseDao.insert(pojo);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public T selectByPrimaryKey(Integer id) {
		return baseDao.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(T pojo) {
		return baseDao.updateByPrimaryKeySelective(pojo);
	}

	@Override
	public List<T> getList(PojoParam param) {
		return baseDao.getList(param);
	}
	
	@Override
	public PageInfo<T> getListPage(PojoParam param) {
		BaseQueryParam baseParam = (BaseQueryParam) param ;
		PageHelper.startPage(baseParam.getOffset()/baseParam.getLimit() + 1,baseParam.getLimit(), true);
		return new PageInfo<T>(baseDao.getList(param));
	}
	
	@Transactional
	@Override
	public int deleteBatch(String ids) {
		String idArr[] = ids.split(",");
		List<Integer> idList = new ArrayList<Integer>(idArr.length);
		for(String id : idArr){
			idList.add(Integer.parseInt(id));
		}
		return baseDao.deleteByPrimaryKeyBatch(idList);
	}

	
	
}
