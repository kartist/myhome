package com.angelachen.myhome.service;

import com.angelachen.myhome.common.model.User;

import javax.validation.constraints.NotNull;

/**
 * @author Kartist 2018/10/4 22:21
 */
public interface UserService {


    /**
     * 验证用户是否存在
     *
     * @param userName 用户名
     * @param password 密码
     * @return 验证通过 返回用户对象
     * @throws com.angelachen.myhome.common.exception.AccessException 验证不通过抛出认证异常
     */
    User doLogin(@NotNull String userName, @NotNull String password);

}
