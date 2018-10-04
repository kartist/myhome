package com.angelachen.myhome.common.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author Kartist 2018/10/4 14:36
 */
@Data
public class ImageDto {

    String fileName;

    String filePath;

    Date uploadTime;

}
