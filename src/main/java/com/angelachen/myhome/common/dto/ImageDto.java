package com.angelachen.myhome.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kartist 2018/10/4 14:36
 */
@Data
public class ImageDto {

    /**
     * 源文件名
     */
    String fileName;

    /**
     * 文件相对路径
     */
    String filePath;

    /**
     * 上传时间
     */
    Date uploadTime;

    /**
     * 文件后缀 不包含 .
     */
    String suffix;

}
