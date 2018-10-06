package com.angelachen.myhome.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserEntity {
    private Integer id;

    private Date createTime;

    private String name;

    private String password;

    private String phone;

    private String address;

    private String note;

    private Date lastLoginTime;

    private Boolean showBack;
}