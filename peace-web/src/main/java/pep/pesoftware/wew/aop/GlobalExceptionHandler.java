package pep.pesoftware.wew.aop;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pep.pesoftware.wew.exception.BaseException;
import pep.pesoftware.wew.form.BaseForm;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public BaseForm handleException(Exception exception, HttpServletResponse response){
        if (exception instanceof BaseException){
            BaseException baseException = (BaseException) exception;
            int httpStatusCode = baseException.getHttpStatus().value();
            String errorCode = baseException.getCode();
            String errorMsg = baseException.getMessage();
            response.setStatus(httpStatusCode);
            return new BaseForm(errorCode,errorMsg);
        }else{
            log.error("系统异常",exception);
            return new BaseForm("E001","系统异常");
        }
    }

}
