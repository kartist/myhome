package com.angelachen.myhome.common.exception;

import lombok.Getter;

/**
 * @author Kartist 2018/10/4 14:28
 */
@Getter
public class ServiceException extends RuntimeException {


    private String message;

    private String logStr;

    private Object[] causeObj;

    public ServiceException() {
        super();
    }


    public ServiceException(String message, String logStr, Object... objs) {
        this.message = message;
        this.logStr = logStr;
        this.causeObj = objs;
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
