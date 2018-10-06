package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.dto.CommentDto;
import com.angelachen.myhome.common.dto.CommentListDto;
import com.angelachen.myhome.common.model.JsonResult;
import com.angelachen.myhome.common.model.PageResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import com.angelachen.myhome.service.CommentService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author Kartist 2018/9/21 22:30
 */
@RestController
@RequestMapping("/comment/")
@Validated
public class CommentController {


    @Resource
    private CommentService commentService;

    @PostMapping("save")
    public JsonResult save(@NotBlank String content, HttpServletRequest request) {
        User user = UserUtil.getGoodUser(request);
        CommentDto commentDto = commentService.saveComment(content, user);
        return new JsonResult(commentDto);
    }

    @PostMapping("list")
    public JsonResult getList(@NotNull Integer current, @NotNull Integer size) {

        final PageResult<CommentListDto> pageResult = commentService.getList(current, size);

        return new JsonResult(pageResult);
    }


}
