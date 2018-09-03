package pep.pesoftware.wew.aop;

//@ControllerAdvice
//@Slf4j
public class GlobalExceptionHandler {

//    @ExceptionHandler(value = Exception.class)
//    @ResponseBody
//    public BaseForm handleException(Exception exception, HttpServletResponse response){
//        if (exception instanceof BaseException){
//            BaseException baseException = (BaseException) exception;
//            int httpStatusCode = baseException.getHttpStatus().value();
//            String errorCode = baseException.getCode();
//            String errorMsg = baseException.getMessage();
//            response.setStatus(httpStatusCode);
//            return new BaseForm(errorCode,errorMsg);
//        }else{
//            log.error("系统异常",exception);
//            return new BaseForm("E001","系统异常");
//        }
//    }

}
