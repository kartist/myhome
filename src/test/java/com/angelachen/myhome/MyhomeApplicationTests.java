package com.angelachen.myhome;

import com.angelachen.myhome.common.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyhomeApplicationTests {


    protected Logger logger = LoggerFactory.getLogger(MyhomeApplicationTests.class);

    protected User user = new User();

    {
        user.setId(90);
        user.setName("test");
        user.setPassword("123");
    }

    @Test
    public void contextLoads() {
    }

}
