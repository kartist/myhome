package com.angelachen.myhome.service.impl;

import com.angelachen.myhome.MyhomeApplicationTests;
import com.angelachen.myhome.service.CommentService;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author Kartist 2018/10/6 10:49
 */
public class CommentServiceImplTest extends MyhomeApplicationTests {


    @Resource
    private CommentService commentService;

    @Transactional
    @Rollback
    @Test
    public void saveComment() {
        for (int i = 0; i < 5; i++) {
            commentService.saveComment("test comment " + i, user);
        }
    }

    @Test
    public void getList() {
    }
}