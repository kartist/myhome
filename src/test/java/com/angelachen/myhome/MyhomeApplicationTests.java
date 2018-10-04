package com.angelachen.myhome;

import com.angelachen.myhome.common.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyhomeApplicationTests {

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
