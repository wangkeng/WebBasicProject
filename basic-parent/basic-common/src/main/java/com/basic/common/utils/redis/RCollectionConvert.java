package com.basic.common.utils.redis;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.redisson.api.RMap;

/**
 * redisson集合处理类
 * 将redisson集合类转成java集合或对象
 * 
 * @author Administrator
 * 
 */
public class RCollectionConvert {

	public static <T> T mMapToObj(RMap<String, Object> map, Class<T> clz)
			throws Exception {
		if (map == null)
			return null;
		T obj = clz.newInstance();
		BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
		PropertyDescriptor[] propertyDescriptors = beanInfo
				.getPropertyDescriptors();
		for (PropertyDescriptor property : propertyDescriptors) {
			Method setter = property.getWriteMethod();
			if (setter != null) {
				setter.invoke(obj, map.get(property.getName()));
			}
		}
		return obj;
	}
}
