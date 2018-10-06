package com.angelachen.myhome.service.impl;

import com.angelachen.myhome.common.dto.CommentDto;
import com.angelachen.myhome.common.dto.CommentListDto;
import com.angelachen.myhome.common.model.PageResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.entity.MessageEntity;
import com.angelachen.myhome.mapper.MessageEntityMapper;
import com.angelachen.myhome.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Kartist 2018/10/6 0:43
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private MessageEntityMapper messageEntityMapper;


    /**
     * 保存用户的留言
     *
     * @param content 留言内容
     * @param user    留言用户
     * @return 保存的留言dto
     */
    @Override
    public CommentDto saveComment(String content, User user) {
        MessageEntity messageEntity = new MessageEntity();
        messageEntity.setContent(content);
        messageEntity.setCreateUser(user.getId());
        messageEntity.setCreateTime(new Date());
        messageEntity.setDelete(false);
        messageEntity.setUserName(user.getName());

        int row = messageEntityMapper.insertSelective(messageEntity);

        CommentDto commentDto = new CommentDto();
        commentDto.setContent(messageEntity.getContent());
        commentDto.setCreateTime(messageEntity.getCreateTime());
        commentDto.setUserName(messageEntity.getUserName());

        return commentDto;
    }

    /**
     * 获取列表 留言时间降序
     *
     * @param current 请求页码
     * @param size    请求页每页数量
     * @return
     */
    @Override
    public PageResult<CommentListDto> getList(int current, int size) {
        int row = messageEntityMapper.countAll();
        PageResult<CommentListDto> pageResult = new PageResult<>(current, size, row);

        List<CommentListDto> list = messageEntityMapper.selectDtoList(pageResult);
        pageResult.setPageData(list);

        return pageResult;
    }
}
