package com.example.missyou.core;

import com.example.missyou.core.configuration.ExceptionCodeConfiguration;
import com.example.missyou.exception.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

@ControllerAdvice
public class GlobalExceptionAdvice {

    @Autowired
    private ExceptionCodeConfiguration codeConfiguration;


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
    public UnifyResponse handleException(HttpServletRequest req,Exception e){
        UnifyResponse message = new UnifyResponse(9999,"服务器异常",req.getMethod()+" "+ req.getRequestURI());
        return message;
    }

    @ExceptionHandler(value = HttpException.class)
    public ResponseEntity<UnifyResponse> handleHttpException(HttpServletRequest req,HttpException e){
        UnifyResponse message =
                new UnifyResponse(e.getCode(),codeConfiguration.getMessage(e.getCode()),req.getMethod()+" "+ req.getRequestURI());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpStatus httpStatus = HttpStatus.resolve(e.getHttpStatusCode());
        ResponseEntity<UnifyResponse> r = new ResponseEntity<>(message,headers,httpStatus);
        return r;
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleBeanValidation(HttpServletRequest req,MethodArgumentNotValidException e){
        String requestUrl = req.getRequestURI();
        String method  = req.getMethod();
        List<ObjectError> errors = e.getBindingResult().getAllErrors();
        String messages = formatAllErrorMessages(errors);
        return new UnifyResponse(10001,messages,method +" "+requestUrl);
    }
    @ExceptionHandler(value = ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public UnifyResponse handleConstraintException(HttpServletRequest req,ConstraintViolationException e){
        String requestUrl = req.getRequestURI();
        String method  = req.getMethod();
        Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();
//        for (ConstraintViolation<?> constraintViolation : e.getConstraintViolations()) {
//            ConstraintViolation<?> constraintViolation1 = constraintViolation;
//        }
        return new UnifyResponse(10001,e.getMessage(),method+" "+requestUrl);
    }

    private String formatAllErrorMessages(List<ObjectError> errors){
        StringBuffer errorMsg = new StringBuffer();
        errors.forEach(error->{
            errorMsg.append(error.getDefaultMessage()).append(";");
        });
        return errorMsg.toString();
    }


}
