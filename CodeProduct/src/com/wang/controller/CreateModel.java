package com.wang.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wang.utils.GetTableName;
import com.wang.utils.TableMessage;

public class CreateModel {
	static Map<String, String> fieldTypeMap = null;
	static String tableName ="";
	
	
	public static void setTableName(String tableName) {
		CreateMapper.tableName = tableName;
		setMapsData();
	}

	static{
		fieldTypeMap = new HashMap<String,String>();
		fieldTypeMap.put("smallint", "Short");
		fieldTypeMap.put("int", "Integer");
		fieldTypeMap.put("bigint", "Long");
		fieldTypeMap.put("bit", "Boolean");
		fieldTypeMap.put("double", "Double");
		fieldTypeMap.put("float", "Float");
		fieldTypeMap.put("decimal", "Long");
		fieldTypeMap.put("char", "String");
		fieldTypeMap.put("varchar", "String");
		fieldTypeMap.put("date", "Date");
		fieldTypeMap.put("time", "Date");
		fieldTypeMap.put("year", "Date");
		fieldTypeMap.put("timestamp", "Date");
		fieldTypeMap.put("datetime", "Date");
		fieldTypeMap.put("bigint", "Long");
	}
	
	@SuppressWarnings("unchecked")
	public static void setMapsData(){
		Map<String,Object> columsMap = TableMessage.getColums("TOPIC_FAVORITE_INFO");
		for (Map<String, Object> map : (List<Map<String, Object>>) columsMap.get("colums")) {
			String columnName = (String) map.get("column_name");
			String dataType = (String) map.get("data_type");
			System.out.println("private "+getJDBCType(dataType)+" "+columnName+"\n");
			
			System.out.println("public "+getJDBCType(dataType)+" get"+GetTableName.firstCharacterToUpper(columnName)+"() { return "+columnName+";} \n");
			System.out.println("public void set"+GetTableName.firstCharacterToUpper(columnName)+"("+getJDBCType(dataType)+" "+columnName+") { this."+columnName+"="+columnName+";} \n");
		}
	}
	
	public static String getJDBCType(String type){
		type = type.toLowerCase();
		if(fieldTypeMap.get(type)!=null){
			return fieldTypeMap.get(type);
		}else{
			return type;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		setTableName("TOPIC_FAVORITE_INFO");
	}
	
}
