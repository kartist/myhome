package com.angelachen.myhome.service;

import com.angelachen.myhome.common.model.User;
import org.springframework.web.multipart.MultipartFile;

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

}
