package com.dubbo.person.service;

import java.util.List;
import java.util.Map;

import com.dubbo.common.base.service.IBaseService;
import com.dubbo.person.model.UserCategory;
import com.dubbo.person.model.UserCategoryQueryModel;


public interface IUserCategoryService extends IBaseService<UserCategory,UserCategoryQueryModel>{

    List<Map<String,Object>> list(Map<String,Object> map);
    
    List<Map<String,Object>> getTreeGrid(Integer nodeid, Integer n_level);


}
