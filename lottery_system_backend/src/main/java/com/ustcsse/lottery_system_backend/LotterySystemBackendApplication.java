package com.ustcsse.lottery_system_backend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.ustcsse.lottery_system_backend.mapper")
public class LotterySystemBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotterySystemBackendApplication.class, args);
    }

}
