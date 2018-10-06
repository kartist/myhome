package com.angelachen.myhome.service.impl;

import com.angelachen.myhome.common.exception.AccessException;
import com.angelachen.myhome.common.model.User;
import com.angelachen.myhome.entity.UserEntity;
import com.angelachen.myhome.entity.UserEntityExample;
import com.angelachen.myhome.mapper.UserEntityMapper;
import com.angelachen.myhome.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

/**
 * @author Kartist 2018/10/4 22:23
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserEntityMapper userEntityMapper;

    @Override
    public User doLogin(@NotNull String userName, @NotNull String password) {
        UserEntityExample userEntityExample = new UserEntityExample();
        final UserEntityExample.Criteria criteria = userEntityExample.createCriteria();
        criteria.andNameEqualTo(userName);
        final UserEntity userEntities = userEntityMapper.selectByUserName(userName);
        if (userEntities == null || !password.equals(userEntities.getPassword())) {
            throw new AccessException("access denied for userName : " + userName);
        }

        User user = new User();
        user.setId(userEntities.getId());
        user.setName(userEntities.getName());
        user.setPassword(userEntities.getPassword());
        user.setShowBack(userEntities.getId() == 0);
        return user;
    }
}
