package com.basic.common.utils.generator;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * 集合与对象之间的转换处理类
 * @author Administrator
 *
 */
public class CollectionObjectConvert {

	public static Map<String,Object> obj2Map(Object obj) throws Exception{
        Map<String,Object> map=new HashMap<String, Object>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
         for (PropertyDescriptor property : propertyDescriptors) { 
             String key = property.getName();
             if (key.compareToIgnoreCase("class") == 0) {   
                    continue;  
                }  
                Method getter = property.getReadMethod();  
                Object value = getter!=null ? getter.invoke(obj) : null;  
                if(value!=null){
                	map.put(key, value); 
                }
         }
        return map;
    }
    
    public static <T> T map2Obj(Map<String,Object> map,Class<T> clz) throws Exception{
        if (map == null)   
            return null;    
        T obj = clz.newInstance();  
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());    
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();    
        for (PropertyDescriptor property : propertyDescriptors) {  
            Method setter = property.getWriteMethod();    
            setter.invoke(obj, map.get(property.getName()));   
        }  
        return obj;
    }
}
