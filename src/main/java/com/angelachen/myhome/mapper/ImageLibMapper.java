package com.angelachen.myhome.mapper;

import com.angelachen.myhome.common.dto.ImageDto;
import com.angelachen.myhome.entity.ImageLibEntity;
import com.angelachen.myhome.entity.ImageLibExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ImageLibMapper {
    long countByExample(ImageLibExample example);

    int deleteByExample(ImageLibExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ImageLibEntity record);

    int insertSelective(ImageLibEntity record);

    List<ImageLibEntity> selectByExample(ImageLibExample example);

    List<ImageDto> selectLimit(int limit);

    List<ImageDto> selectAll();

    ImageLibEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ImageLibEntity record, @Param("example") ImageLibExample example);

    int updateByExample(@Param("record") ImageLibEntity record, @Param("example") ImageLibExample example);

    int updateByPrimaryKeySelective(ImageLibEntity record);

    int updateByPrimaryKey(ImageLibEntity record);
}