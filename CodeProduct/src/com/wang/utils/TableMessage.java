package com.wang.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.wang.db.ConnectionDB;

public class TableMessage {

	private final static String dataBaseName = "topic_test2";
	private final static String userName = "root";
	private final static String password = "123456";
	private final static String url = "jdbc:mysql://localhost:3306/topic_test2";
	
	
	public static List<Map<String,Object>> getTables(){
		ConnectionDB db = new ConnectionDB();
		List<Map<String,Object>> dbList = db.excuteQuery(
				"select table_name from information_schema.tables where table_schema='"
						+ dataBaseName + "' and table_type='base table'",
				null, url, userName, password);
		
		return dbList ;
	}
	
	public static Map<String,Object> getColums(String tableName){
		
		ConnectionDB db = new ConnectionDB();
		List<Map<String,Object>> dbList = db.excuteQuery(
				"select column_name,data_type,column_comment from information_schema.columns where table_schema='"+dataBaseName+"' and table_name='"+tableName+"'",
				null, url, userName, password);
		
		List<Map<String, Object>> primaryKey = db.excuteQuery(
				"SELECT COLUMN_NAME FROM INFORMATION_SCHEMA. COLUMNS WHERE table_name = '"+tableName+"' AND COLUMN_KEY = 'PRI';",
				null, url,userName, password);
		List<String> primaryKeyList = new ArrayList<String>(primaryKey.size());
		Map<String,Object> resultMap = new HashMap<String,Object>();
		for(Map<String,Object> map : primaryKey){
			primaryKeyList .add((String)map.get("COLUMN_NAME"));
		}
		resultMap.put("primaryKey", primaryKeyList);
		resultMap.put("colums", dbList);
		return resultMap ;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(JSON.toJSONString(getTables()));
		System.out.println(JSON.toJSONString(getColums("topic_user_info")));
		
	}
}
