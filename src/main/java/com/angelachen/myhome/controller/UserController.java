package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.model.JsonResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import com.angelachen.myhome.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 登录注册
 * 用户管理
 *
 * @author Kartist 2018/9/21 22:36
 */
@RestController
@RequestMapping("/user/")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("login")
    public JsonResult doLogin(String userName, String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userService.doLogin(userName, password);
        session.setAttribute(UserUtil.SESSION_USER, user);
        return new JsonResult();
    }

    @RequestMapping()
    public JsonResult logOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        final Enumeration<String> attributeNames = session.getAttributeNames();
        List<String> attrbuts = new ArrayList<>();
        while (attributeNames.hasMoreElements()) {
            attrbuts.add(attributeNames.nextElement());
        }
        attrbuts.forEach(session::removeAttribute);
        return new JsonResult();
    }
}
