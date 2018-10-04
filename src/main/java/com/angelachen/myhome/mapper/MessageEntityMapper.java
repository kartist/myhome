package com.angelachen.myhome.mapper;

import com.angelachen.myhome.entity.MessageEntity;
import com.angelachen.myhome.entity.MessageEntityExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageEntityMapper {
    long countByExample(MessageEntityExample example);

    int deleteByExample(MessageEntityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MessageEntity record);

    int insertSelective(MessageEntity record);

    List<MessageEntity> selectByExample(MessageEntityExample example);

    MessageEntity selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MessageEntity record, @Param("example") MessageEntityExample example);

    int updateByExample(@Param("record") MessageEntity record, @Param("example") MessageEntityExample example);

    int updateByPrimaryKeySelective(MessageEntity record);

    int updateByPrimaryKey(MessageEntity record);
}