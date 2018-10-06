package com.angelachen.myhome.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kartist 2018/10/6 0:41
 */
@Data
public class CommentDto {

    private String content;

    private Date createTime;

    private String userName;


}
