package com.angelachen.myhome.service.impl;

import com.angelachen.myhome.common.dto.ImageDto;
import com.angelachen.myhome.common.exception.ServiceException;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.reposit.ImageRepository;
import com.angelachen.myhome.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * @author Kartist 2018/10/4 14:27
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {

    @Resource
    private ImageRepository imageRepository;

    @Override
    public Integer saveUploadImage(MultipartFile multipartFile, User user) {

        String fileName = multipartFile.getOriginalFilename();
        int size = (int) multipartFile.getSize();
        log.info("upload file , name : {} , size : {} Kb", fileName, size);

        String path = "F:/test";
        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            multipartFile.transferTo(dest); //保存文件
            ImageDto imageDto = new ImageDto();
            imageDto.setFileName(fileName);
            imageDto.setUploadTime(new Date());
            imageDto.setFilePath(dest.getPath());

            return imageRepository.createRecord(imageDto, user);
        } catch (IOException e) {
            throw new ServiceException("file save error", e);
        }
    }
}
