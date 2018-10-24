package com.angelachen.myhome.service;

import com.angelachen.myhome.common.dto.ImageDto;
import com.angelachen.myhome.common.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Kartist 2018/10/4 14:24
 */
public interface ImageService {

    /**
     * 保持上传的文件
     *
     * @param multipartFile 上传的文件
     * @return 保存的文件id
     */
    Integer saveUploadImage(MultipartFile multipartFile, User user);

    /**
     * 根据 图片id获取图片信息
     *
     * @param imgId 图片id
     * @return 文件
     */
    ImageDto getImageDtoById(Integer imgId);

    /**
     * 获取轮播图列表
     *
     * @return
     */
    List<ImageDto> roundList();

    /**
     * 获取轮播图列表
     *
     * @return
     */
    List<ImageDto> all();

}
