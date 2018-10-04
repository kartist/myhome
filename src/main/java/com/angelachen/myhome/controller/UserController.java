package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.model.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录注册
 * 用户管理
 *
 * @author Kartist 2018/9/21 22:36
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @RequestMapping("login")
    public JsonResult doLogin(String userName, String password, HttpServletRequest request) {

        return new JsonResult();
    }

    @RequestMapping()

    public JsonResult logOut(HttpServletRequest request) {

        return new JsonResult();
    }
}
