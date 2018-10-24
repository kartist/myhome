package com.angelachen.myhome.service.impl;

import com.angelachen.myhome.common.dto.ImageDto;
import com.angelachen.myhome.common.exception.ServiceException;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.entity.ImageLibEntity;
import com.angelachen.myhome.mapper.ImageLibMapper;
import com.angelachen.myhome.reposit.ImageRepository;
import com.angelachen.myhome.service.ImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 * @author Kartist 2018/10/4 14:27
 */
@Service
@Slf4j
public class ImageServiceImpl implements ImageService {


    private static final List<String> FILE_SUFFIX_LIST = new LinkedList<>();

    static {
        FILE_SUFFIX_LIST.add("jpg");
        FILE_SUFFIX_LIST.add("png");
        FILE_SUFFIX_LIST.add("gif");
        FILE_SUFFIX_LIST.add("jpeg");
    }

    @Value("${config.file.prefix}")
    private String filePrefix;
    @Resource
    private ImageRepository imageRepository;

    @Resource
    private ImageLibMapper imageLibMapper;

    @Override
    public Integer saveUploadImage(MultipartFile multipartFile, User user) {

        String fileName = multipartFile.getOriginalFilename();
        int size = (int) multipartFile.getSize();
        log.info("upload file , name : {} , size : {} Kb", fileName, size);

        String suffix = getFileSuffix(fileName);

        String fileId = UUID.randomUUID().toString();
        File dest = new File(filePrefix + fileId + suffix);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }
        try {
            //保存文件
            multipartFile.transferTo(dest);
            //存入上传数据
            ImageDto imageDto = new ImageDto();
            imageDto.setFileName(fileName);
            imageDto.setUploadTime(new Date());
            imageDto.setFilePath(fileId);
            imageDto.setSuffix(suffix.toLowerCase());

            return imageRepository.createRecord(imageDto, user);
        } catch (IOException e) {
            throw new ServiceException("file save error", e);
        }
    }

    private String getFileSuffix(String fileName) {
        String[] nameParts = fileName.split("\\.");
        int index = nameParts.length;
        if (index == 0) {
            throw new ServiceException("文件后缀不存在", "file name suffix do not exists , fileName : {}", fileName);
        }
        final String namePart = nameParts[index - 1];
        for (String str : FILE_SUFFIX_LIST) {
            if (str.equalsIgnoreCase(nameParts[index - 1])) {
                return nameParts[index - 1];
            }
        }
        throw new ServiceException("文件名后缀不匹配", "file name suffix do not match , fileName : {}", fileName);
    }


    @Override
    public ImageDto getImageDtoById(Integer imgId) {
        ImageLibEntity imageLibEntity = imageLibMapper.selectByPrimaryKey(imgId);
        if (imageLibEntity == null) {
            throw new ServiceException("图片不存在", "image not exists , imgId : {} ", imgId);
        }
        ImageDto imageDto = new ImageDto();
        imageDto.setFileName(imageLibEntity.getTitle());
        imageDto.setUploadTime(imageLibEntity.getCreateTime());
        imageDto.setFilePath(imageLibEntity.getPath());
        imageDto.setSuffix(imageLibEntity.getSuffix());
        return imageDto;
    }
}
