package com.angelachen.myhome.controller;

import com.angelachen.myhome.common.model.JsonResult;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.common.util.UserUtil;
import com.angelachen.myhome.entity.UserEntity;
import com.angelachen.myhome.mapper.UserEntityMapper;
import com.angelachen.myhome.service.UserService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
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
@Validated
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private UserEntityMapper userEntityMapper;

    @RequestMapping("login")
    public JsonResult doLogin(@NotNull String userName, @NotNull String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = userService.doLogin(userName, password);
        session.setAttribute(UserUtil.SESSION_USER, user);
        return new JsonResult();
    }

    @RequestMapping("logout")
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

    @PostMapping("/regist")
    @Transactional(rollbackFor = Exception.class)
    public JsonResult regist(@NotNull String userName, @NotNull String password, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserEntity userEntity = userEntityMapper.selectByUserName(userName);
        if (userEntity != null) {
            return new JsonResult(2, " have regist ");
        }
        userEntity = new UserEntity();
        userEntity.setName(userName);
        userEntity.setPassword(password);
        userEntityMapper.insertSelective(userEntity);

        UserEntity createdUser = userEntityMapper.selectByUserName(userName);
        User user = new User(createdUser);
        session.setAttribute(UserUtil.SESSION_USER, user);
        return new JsonResult();
    }
}
