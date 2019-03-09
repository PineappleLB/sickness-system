package com.sickness.exception;

/**
 * 自定义异常类
 *
 * @author pineapple
 * @create 2019/3/5
 */
public class ServiceException extends Exception{

    public ServiceException(){}

    public ServiceException(String message){
        super(message);
    }

    public ServiceException(Throwable t, String message){
        super(message, t);
    }

}
