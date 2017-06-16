package com.dubbo.common.base.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IBaseDao<Pojo,PojoParam> {

    
    
    /**
     * 新增
     * @param record
     * @return
     */
    int insert(Pojo pojo);

    
    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
    
    /**
     * 根据id批量删除
     * @param id
     * @return
     */
    int deleteByPrimaryKeyBatch(@Param("list")List<?> list);

   

    /**
     * 根据id获取pojo
     * @param id
     * @return
     */
    Pojo selectByPrimaryKey(Integer id);


    /**
     * 通过多个条件获取map列表
     * @param map
     * @return
     */
    List<Map<String,Object>> getMaps(Map<String,Object> map);
    /**
     * 通过多个条件获取pojo     * @return
     */
    List<Pojo> getList(PojoParam param);
    
    
    int updateByPrimaryKey(Pojo pojo);
    
    
    int updateByPrimaryKeySelective(Pojo pojo);
    
    
}
