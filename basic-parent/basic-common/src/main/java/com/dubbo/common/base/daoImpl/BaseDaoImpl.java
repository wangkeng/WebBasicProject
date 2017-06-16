package com.dubbo.common.base.daoImpl;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;

import com.dubbo.common.base.dao.IBaseDao;


@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class BaseDaoImpl<TDao, TPojo,TPojoParam> implements
		IBaseDao<TPojo,TPojoParam> {

	@Resource
	protected SqlSession session;

	/**
	 * 通过类型获取mapper
	 * @return
	 */
	public TDao getMapper() {
		return this.session.getMapper(getClassType());
	}

	/**
	 * 获取mapper类型
	 * @return
	 */
	public Class<TDao> getClassType() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		return (Class<TDao>) pt.getActualTypeArguments()[0];
	}

	/**
	 * 插入数据
	 */
	public int insert(TPojo pojo){
		return ((IBaseDao) getMapper()).insert(pojo);
	}

	/**
	 * 根据id删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKey(Integer id){
		return ((IBaseDao) getMapper()).deleteByPrimaryKey(id);
	}

	/**
	 * 根据id批量删除
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByPrimaryKeyBatch(List<?> list){
		return ((IBaseDao) getMapper()).deleteByPrimaryKeyBatch(list);
	}

	/**
	 * 根据id获取pojo
	 * 
	 * @param id
	 * @return
	 */
	public TPojo selectByPrimaryKey(Integer id){
		return (TPojo) ((IBaseDao) getMapper()).selectByPrimaryKey(id);
	}

	/**
	 * 通过多个条件获取map列表
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getMaps(Map<String, Object> map){
		return ((IBaseDao) getMapper()).getMaps(map);
	}

	/**
	 * 通过多个条件获取pojo * @return
	 */
	public List<TPojo> getList(Map<String, Object> map){
		return ((IBaseDao) getMapper()).getList(map);
	}

	/**
	 * 修改全部字段
	 */
	public int updateByPrimaryKey(TPojo pojo){
		return ((IBaseDao) getMapper()).updateByPrimaryKey(pojo);
	}

	/**
	 * 修改不为空的字段
	 */
	public int updateByPrimaryKeySelective(TPojo pojo){
		return ((IBaseDao) getMapper()).updateByPrimaryKeySelective(pojo);
	}
	
	
	public List<TPojo> getList(TPojoParam param) {
		return ((IBaseDao) getMapper()).getList(param);
	}

}
