package com.angelachen.myhome.common.model;

import lombok.Data;

/**
 * 自定义封装请求的返回对象
 * 在controller中返回json时,以这个对象返回
 *
 * @author Kartist
 */
@Data
public class JsonResult {

    public enum ResultState {
        SUCCESS(1, "OK"),
        SERVER_ERROR(500, "ERROR");

        private int code;

        ResultState(int code, String message) {
            this.code = code;
            this.message = message;
        }

        private String message;

        public int getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

    }

    /**
     * 状态
     */
    private int state;
    /**
     * 对应状态的消息
     */
    private String message;
    /**
     * 具体业务数据
     */
    private Object data;

    /**
     * 此构造方法应用于data为null的场景
     */
    public JsonResult() {
        this(ResultState.SUCCESS);
    }

    /**
     * 有具体业务数据返回时,使用此构造方法
     */
    public JsonResult(ResultState resultState) {
        this.state = resultState.getCode();
        this.message = resultState.getMessage();
    }

    /**
     * 有具体业务数据返回时,使用此构造方法
     */
    public JsonResult(Object data) {
        this();
        this.data = data;
    }

    public JsonResult(int state, String message) {
        this.state = state;
        this.message = message;
    }

    /**
     * 出现异常以后要调用此方法封装异常信息
     * 能够对异常的类型进行判断,根据不同的异常类型返回
     */
    public JsonResult(Throwable t) {
        this(ResultState.SERVER_ERROR);
    }

    /**
     * 出现异常以后要调用此方法封装异常信息
     * 返回异常信息的描述
     */
    public JsonResult(Throwable t, String message) {
        this(ResultState.SERVER_ERROR);
        this.message = message;
    }

}
