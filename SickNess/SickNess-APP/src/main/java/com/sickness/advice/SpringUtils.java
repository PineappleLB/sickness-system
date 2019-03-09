package com.sickness.advice;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * spring 帮助类
 *
 * @author pineapple
 * @create 2019/3/5
 */
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        if(SpringUtils.applicationContext == null){
            SpringUtils.applicationContext = applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    //根据name
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);
    }

    //根据类型
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name,clazz);
    }
}
