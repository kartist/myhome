package com.angelachen.myhome.reposit;

import com.angelachen.myhome.common.dto.ImageDto;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.entity.ImageLibEntity;
import com.angelachen.myhome.mapper.ImageLibMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Kartist 2018/10/4 14:34
 */
@Component
public class ImageRepository {

    @Resource
    private ImageLibMapper imageLibMapper;

    public Integer createRecord(ImageDto imageDto, User user) {
        ImageLibEntity imageLibEntity = new ImageLibEntity();
        imageLibEntity.setCreateTime(imageDto.getUploadTime());
        imageLibEntity.setCreateUser(user.getId());
        imageLibEntity.setTitle(imageDto.getFileName());
        imageLibEntity.setPath(imageDto.getFilePath());
        imageLibEntity.setSuffix(imageDto.getSuffix());

        imageLibMapper.insertSelective(imageLibEntity);
        return imageLibEntity.getId();
    }
}
