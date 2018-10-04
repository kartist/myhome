package com.angelachen.myhome.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class MessageEntity extends BaseEntity {

    private Date createTime;

    private Integer createUser;

    private String userName;

    private Boolean delete;

    private String content;

}