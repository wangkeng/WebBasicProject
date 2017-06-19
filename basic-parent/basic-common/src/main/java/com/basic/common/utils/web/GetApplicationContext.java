package com.basic.common.utils.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class GetApplicationContext {

    private static class ApplicationContextHolder {  
        // 单例变量  
        private static ApplicationContext AC = new FileSystemXmlApplicationContext(  
                "classpath:spring/ApplicationContext.xml");  
    }  
  
  
    // 私有化的构造方法，保证外部的类不能通过构造器来实例化。  
    private GetApplicationContext() {  
  
  
    }  
  
  
    // 获取单例对象实例  
    public static ApplicationContext getInstance() {  
        if (ApplicationContextHolder.AC == null) {  
            ApplicationContextHolder.AC = new FileSystemXmlApplicationContext(  
                    "classpath:applicationContext.xml");  
        }  
        return ApplicationContextHolder.AC;  
    }  
}
