package com.angelachen.myhome.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = true)
@Data
public class ImageLibEntity extends BaseEntity {

    private Date createTime;

    private Integer createUser;

    private Boolean delete;

    private String path;

    private String title;

    private String description;

}