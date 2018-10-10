package com.angelachen.myhome;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

@MapperScan("com.angelachen.myhome.mapper")
@SpringBootApplication
public class MyhomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyhomeApplication.class, args);
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
