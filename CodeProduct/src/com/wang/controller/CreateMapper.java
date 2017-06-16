package com.wang.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wang.utils.FileUtils;
import com.wang.utils.GetTableName;
import com.wang.utils.TableMessage;
@SuppressWarnings("unchecked")
public class CreateMapper {
	
	static Map<String, String> fieldTypeMap = null;
	static Map<String,String> columnTypeMap = null ;
	static ArrayList<String> primaryKeyList = null ;
	static String tableName ="";
	static Map<String,Object> columsMap =null;
	
	
	public static void setTableName(String tableName) {
		CreateMapper.tableName = tableName;
		setMapsData();
	}

	static{
		fieldTypeMap = new HashMap<String,String>();
		columnTypeMap = new HashMap<String,String>();
		columsMap =  new HashMap<String,Object>();
		fieldTypeMap.put("datetime", "TIMESTAMP");
		fieldTypeMap.put("int", "INTEGER");
		fieldTypeMap.put("year", "DATE");
	}
	
	public static void setMapsData(){
		columsMap = TableMessage.getColums(tableName);
		primaryKeyList = (ArrayList<String>) columsMap.get("primaryKey");
		for (Map<String, Object> map : (List<Map<String, Object>>) columsMap.get("colums")) {
			String columnName = (String) map.get("column_name");
			String dataType = (String) map.get("data_type");
			columnTypeMap.put(columnName, getJDBCType(dataType));
		}
	}
	
	public static String getBaseResultMap(){
		StringBuffer buffer = new StringBuffer();
		String type = "result";
		for(String key : columnTypeMap.keySet()){
			if(primaryKeyList.contains(key)){
				type = "id";
				buffer.insert(0,"<" + type + " column=" + "\"" + key
						+ "\" property=\"" + key + "\" jdbcType=\""
						+ getJDBCType(columnTypeMap.get(key)) + "\" /> \n");
			}else{
				type = "result";
				buffer.append("<" + type + " column=" + "\"" + key
						+ "\" property=\"" + key + "\" jdbcType=\""
						+ getJDBCType(columnTypeMap.get(key)) + "\" /> \n");
			}
			
		}
		return buffer.toString();
	}
	
	/**
	 * 
	 * @param type : columns 表示获取所有字段     values 表示获取所有设值字段 
	 * @return
	 */
	public static String getColumnList(String type){
		StringBuffer buffer = new StringBuffer();
		int i = 0 ;
		for(String key : columnTypeMap.keySet()){
			if(type.equals("columns")){
				buffer.append(key+",");
			}else if(type.equals("values")){
				buffer.append("#{"+key+",jdbcType="+getJDBCType(columnTypeMap.get(key))+"},");
			}
			if(i%5==0){
				buffer.append("\n");
			}
			i++;
		}
		return buffer.toString().substring(0,buffer.toString().lastIndexOf(","));
	}
	
	public static Map<String,String> getColumnList(){
		StringBuffer columnsBuffer = new StringBuffer();
		StringBuffer valuesBuffer = new StringBuffer();
		for(String key : columnTypeMap.keySet()){
			if(!primaryKeyList.contains(key)){
				columnsBuffer.append(key+",");
				valuesBuffer.append("#{"+key+",jdbcType="+getJDBCType(columnTypeMap.get(key))+"},");
			}
		}
		Map<String,String> map = new HashMap<String,String>();
		map.put("columns", columnsBuffer.toString().substring(0,columnsBuffer.toString().lastIndexOf(",")));
		map.put("values", valuesBuffer.toString().substring(0,valuesBuffer.toString().lastIndexOf(",")));
		return map;
	}
	
	public static String getSetValue(boolean check){
		StringBuffer buffer = new StringBuffer(); 
		for(String key : columnTypeMap.keySet()){
			if(check){
				buffer.append("<if test=\""+key+" != null\"> \n");
				buffer.append( key+"= #{"+key+",jdbcType="+columnTypeMap.get(key)+"}, \n");
				buffer.append( "</if> \n");
			}else{
				buffer.append( key+"= #{"+key+",jdbcType="+columnTypeMap.get(key)+"}, \n");
			}
		}
		String result = buffer.toString();
		if(!check){
			result = result.substring(0,result.lastIndexOf(","));
		}
		return result;
	}
	
	public static String getJDBCType(String type){
		if(fieldTypeMap.get(type)!=null){
			return fieldTypeMap.get(type);
		}else{
			return type.toUpperCase();
		}
	}
	
	
	public static String getPrimaryKeyWhere(){
		if(primaryKeyList.size()>1){
			StringBuffer buffer = new StringBuffer();
			for(String str: primaryKeyList){
				buffer.append( "and "+str+"="+"#{"+str+",jdbcType="+columnTypeMap.get(str)+"} ");
			}
			return buffer.toString().substring(buffer.toString().indexOf("and")+3);
		}else{
			String str = primaryKeyList.get(0);
			return str+"="+"#{"+str+",jdbcType="+columnTypeMap.get(str)+"}";
		}
	}
	
	public static String createMapper(String str , String tableName ,String pacakage){
		setTableName(tableName);
		str = str.replaceAll("\\$\\{setPackage\\}", pacakage);
		str = str.replaceAll("\\$\\{setModelName\\}", GetTableName.changeTableName(tableName,true));
		str = str.replaceAll("\\$\\{getBaseResultMap\\}", getBaseResultMap());
		str = str.replaceAll("\\$\\{getColumnList\\(columns\\)\\}", getColumnList("columns"));
		str = str.replaceAll("\\$\\{setTableName\\}", tableName);
		str = str.replaceAll("\\$\\{getPrimaryKeyWhere\\}", getPrimaryKeyWhere());
		str = str.replaceAll("\\$\\{getSetValue\\(true\\)\\}", getSetValue(true));
		str = str.replaceAll("\\$\\{getSetValue\\(false\\)\\}", getSetValue(false));
		Map<String,String> map = getColumnList();
		str = str.replaceAll("\\$\\{getColumnList\\(before\\)\\}", map.get("columns"));
		str = str.replaceAll("\\$\\{getColumnList\\(after\\)\\}", map.get("values"));
		return str;
	}
	public static void main(String[] args) throws IOException {
		
		
	}
}
