package org.vincent.exception;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author PengRong
 * @package org.vincent.exception
 * @ClassName GlobleExceptionHandler.java
 * @date 2019/5/30 - 0:17
 * @ProjectName Web-Tutorial
 * @Description: 全局异常处理
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {
    /**
     * 全局处理 bind 数据绑定异常,将堆栈信息输出
     *
     * @param request
     * @param validException
     * @return
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, BindException.class})
    public String exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception validException) {
        //response.setContentType(MediaType.TEXT_PLAIN_VALUE+";charset=UTF-8");
        if (validException instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) validException;
            List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
            //多个错误，取第一个
            FieldError error = fieldErrors.get(0);
            String msg = error.getDefaultMessage();
            return msg;
        } else if (validException instanceof BindException) {
            BindException ex = (BindException) validException;
            return ex.getBindingResult().toString();
        }
        return "";
    }
}
