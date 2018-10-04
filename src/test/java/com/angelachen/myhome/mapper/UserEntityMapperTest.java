package com.angelachen.myhome.mapper;

import com.angelachen.myhome.MyhomeApplicationTests;
import com.angelachen.myhome.entity.UserEntity;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

/**
 * @author Kartist 2018/10/4 22:44
 */
public class UserEntityMapperTest extends MyhomeApplicationTests {

    @Resource
    private UserEntityMapper userEntityMapper;

    @Test
    public void selectByUserName() {
        final UserEntity userEntity = userEntityMapper.selectByUserName(user.getName());
        logger.info("user entity : {}", userEntity);
        assertNotNull(userEntity);

    }
}