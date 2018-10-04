package com.angelachen.myhome.reposit;

import com.angelachen.myhome.MyhomeApplicationTests;
import com.angelachen.myhome.common.dto.ImageDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * @author Kartist 2018/10/4 15:35
 */
@Slf4j
public class ImageRepositoryTest extends MyhomeApplicationTests {


    @Resource
    private ImageRepository imageRepository;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Transactional
    @Rollback
    @Test
    public void createRecord() {
        ImageDto imageDto = new ImageDto();
        imageDto.setFilePath("test/test");
        imageDto.setUploadTime(new Date());
        imageDto.setFileName("test.file");

        Integer id = imageRepository.createRecord(imageDto, user);
        log.info("id : {}", id);
        assertNotNull(id);
    }
}