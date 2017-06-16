package com.dubbo.common.base.service;

import java.util.List;

import com.github.pagehelper.PageInfo;



public interface IBaseService<T,PojoParam> {

	
	  /**
     * 新增
     * @param pojo
     * @return
     */
    int insert(T pojo);

    
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    


    /**
     * 根据id获取pojo
     * @param id
     * @return
     */
    T selectByPrimaryKey(Integer id);


    
    /**
     * 根据不为空的字段更新
     * @param pojo
     * @return
     */
    int updateByPrimaryKeySelective(T pojo);
    
    
    
    List<T> getList(PojoParam param);


	PageInfo<T> getListPage(PojoParam param);


	int deleteBatch(String ids);
}
