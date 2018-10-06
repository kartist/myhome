package com.angelachen.myhome.service;

import com.angelachen.myhome.common.dto.CommentDto;
import com.angelachen.myhome.common.dto.CommentListDto;
import com.angelachen.myhome.common.model.PageResult;
import com.angelachen.myhome.common.model.User;

/**
 * @author Kartist 2018/10/6 0:41
 */
public interface CommentService {

    /**
     * 保存用户的留言
     *
     * @param content 留言内容
     * @param user    留言用户
     * @return 保存的留言dto
     */
    CommentDto saveComment(String content, User user);

    /**
     * 获取列表 留言时间降序
     *
     * @param current 请求页码
     * @param size    请求页每页数量
     * @return
     */
    PageResult<CommentListDto> getList(int current, int size);


}
