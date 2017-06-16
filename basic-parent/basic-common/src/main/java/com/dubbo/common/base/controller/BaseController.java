package com.dubbo.common.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class BaseController {

	private static Logger logger ;

	protected void setLogger(Logger outLogger){
		logger = outLogger ;
	}
	
	
	//全局异常处理
	@ExceptionHandler
	public String exception(HttpServletRequest request,
			HttpServletResponse response, Exception e) {
		// 这里进行通用处理，如日志记录�?..
		StackTraceElement[] es = e.getStackTrace();
		for (StackTraceElement s : es) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
			logger.info(df.format(new Date()) + "--" + s.toString());
		}
		// 如果是json格式的ajax请求
		if (request.getHeader("accept").indexOf("application/json") > -1
				|| (request.getHeader("X-Requested-With") != null && request
						.getHeader("X-Requested-With")
						.indexOf("XMLHttpRequest") > -1)) {
			response.setStatus(500);
			response.setContentType("application/json;charset=utf-8");
			try {
				PrintWriter writer = response.getWriter();
				writer.write(e.getMessage());
				writer.flush();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			return null;
		} else {// 如果是普通的异常
			request.setAttribute("exceptionMessage", e.getMessage());
			return "error/testerror";
		}
	}
}
