package com.angelachen.myhome.common.model;

import lombok.Data;

/**
 * @author Kartist 2018/10/4 7:57
 */
@Data
public class User {

    private Integer id;

    private String name;

    private String password;

    /**
     * 标识是否允许进入后台
     */
    private boolean showBack = false;

}
