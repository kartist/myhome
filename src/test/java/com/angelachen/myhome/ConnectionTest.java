package com.angelachen.myhome;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

/**
 * @author Kartist 2018/10/6 10:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ConnectionTest {

    private Logger logger = LoggerFactory.getLogger(ConnectionTest.class);

    @Autowired
    private DataSource dataSource;

    @Test
    public void test1() {
        logger.info("datasource: " + dataSource);
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            logger.info("connection: " + connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        assertNotNull(connection);
    }
}
