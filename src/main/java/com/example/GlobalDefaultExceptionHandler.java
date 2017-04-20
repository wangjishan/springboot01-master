package com.example;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局异常的捕捉
 * <p>
 * Created by user on 2017/4/20.
 */

@ControllerAdvice
public class GlobalDefaultExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest req, Exception e) {
        System.out.println("全局异常====");
        e.printStackTrace();
    }


}
