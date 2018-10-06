package com.angelachen.myhome.common.exception;

import com.angelachen.myhome.common.model.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Kartist 2018/10/4 16:31
 */
@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler(value = ServiceException.class)
    public JsonResult adviceServiceException(ServiceException e) {
        log.error(e.getLogStr(), e.getCauseObj());
        return new JsonResult(e.getMessage());
    }

    @ExceptionHandler(value = AccessException.class)
    public JsonResult adviceAccessException(AccessException e) {
        log.warn("access no permission ", e);
        return new JsonResult(JsonResult.ResultState.ACCESS_REFUSED);
    }

    @ExceptionHandler(value = Exception.class)
    public JsonResult adviceException(Exception e) {
        log.error(" exception : {}", e);
        return new JsonResult(JsonResult.ResultState.SERVER_ERROR);
    }


}
