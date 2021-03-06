package com.angelachen.myhome.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.angelachen.myhome.common.dto.CommentDto;
import com.angelachen.myhome.common.dto.CommentListDto;
import com.angelachen.myhome.common.model.JsonResult;
import com.angelachen.myhome.common.model.PageResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import com.angelachen.myhome.service.CommentService;
import com.angelachen.myhome.socket.WebSocketServer;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.IOException;

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
    public JsonResult save(@NotBlank String content, HttpServletRequest request) throws IOException {
        User user = UserUtil.getGoodUser(request);
        CommentDto commentDto = commentService.saveComment(content, user);
        sendSocketMessage(commentDto);
        return new JsonResult(commentDto);
    }

    @PostMapping("list")
    public JsonResult getList(@NotNull Integer current, @NotNull Integer size) {

        final PageResult<CommentListDto> pageResult = commentService.getList(current, size);

        return new JsonResult(pageResult);
    }

    private void sendSocketMessage(CommentDto commentDto) throws IOException {
        WebSocketServer.sendInfo(JSON.toJSONString(commentDto, SerializerFeature.WriteDateUseDateFormat));
    }


}
