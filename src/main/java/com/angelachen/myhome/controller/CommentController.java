package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.model.JsonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kartist 2018/9/21 22:30
 */
@RestController
@RequestMapping("/comment/")
public class CommentController {


    @PostMapping("save")
    public JsonResult save(String comment, HttpServletRequest request) {

        return new JsonResult();
    }

    @PostMapping("list")
    public JsonResult getList(Integer current, Integer size) {

        return new JsonResult();
    }


}
