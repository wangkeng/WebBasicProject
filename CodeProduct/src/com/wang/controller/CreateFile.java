package com.wang.controller;

import java.io.IOException;

import com.wang.utils.FileUtils;
import com.wang.utils.GetTableName;

public class CreateFile {

	private static String tableName = "TOPIC_USER_INFO";
	private static String packageName = "com.dubbo.person";
	

	public static void createDao() {
		//Map<String,Object> columsMap = TableMessage.getColums(tableName);
		String str = FileUtils.readTxtFile("src/com/wang/temp/dao.txt");
		str = str.replaceAll("\\$\\{setPackage\\}", packageName);
		str = str.replaceAll("\\$\\{setModelName\\}", GetTableName.changeTableName(tableName,true));
		System.out.println(str);
	}
	
	public static void createDaoImpl() {
		String str = FileUtils.readTxtFile("src/com/wang/temp/daoImpl.txt");
		str = str.replaceAll("\\$\\{setPackage\\}", packageName);
		str = str.replaceAll("\\$\\{setModelName\\}", GetTableName.changeTableName(tableName,true));
		System.out.println(str);
	}
	
	public static void createService() {
		String str = FileUtils.readTxtFile("src/com/wang/temp/service.txt");
		str = str.replaceAll("\\$\\{setPackage\\}", packageName);
		str = str.replaceAll("\\$\\{setModelName\\}", GetTableName.changeTableName(tableName,true));
		System.out.println(str);
	}
	
	public static void createServiceImpl() {
		String str = FileUtils.readTxtFile("src/com/wang/temp/serviceImpl.txt");
		str = str.replaceAll("\\$\\{setPackage\\}", packageName);
		str = str.replaceAll("\\$\\{setModelNameDownCase\\}", GetTableName.changeTableName(tableName,false));
		str = str.replaceAll("\\$\\{setModelName\\}", GetTableName.changeTableName(tableName,true));
		System.out.println(str);
	}
	
	public static void createController() {
		String str = FileUtils.readTxtFile("src/com/wang/temp/controller.txt");
		str = str.replaceAll("\\$\\{setPackage\\}", packageName);
		str = str.replaceAll("\\$\\{setModelNameDownCase\\}", GetTableName.changeTableName(tableName,false));
		str = str.replaceAll("\\$\\{setModelName\\}", GetTableName.changeTableName(tableName,true));
		System.out.println(str);
	}
	
	public static void createMapper() {
		/*String str = FileUtils.readTxtFile("src/com/wang/temp/mapper.txt");
		str = CreateMapper.createMapper(str, tableName, packageName);
		System.out.println(str);*/
		
		String str2 = FileUtils.readTxtFile("src/com/wang/temp/mapper.txt");
		str2 = CreateMapper.createMapper(str2, "TOPIC_FAVORITE_INFO", packageName);
		System.out.println(str2);
	}

	public static void main(String[] args) throws IOException {
		
		createMapper();
	}
	
	
	
	


}
