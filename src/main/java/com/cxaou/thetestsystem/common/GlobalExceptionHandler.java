package com.cxaou.thetestsystem.common;

import com.cxaou.thetestsystem.erro.ParameterException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@Slf4j
@ResponseBody
@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class GlobalExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)  // 要处理的异常
    public R<String> exceptionHandler(SQLIntegrityConstraintViolationException ex){

        String message = ex.getMessage();
        log.error("错误信息：{}",message);
        if (message.contains("Duplicate entry")){
            String[] s = message.split(" ");
            String msg = s[2]+ "已存在";
            return  R.error(msg);
        }
        return R.error("未知错误");

    }

    @ExceptionHandler(ParameterException.class)  // 要处理的异常
    public R<String> exceptionHandler(ParameterException ex){
        return R.error(ex.getMessage());

    }
}
