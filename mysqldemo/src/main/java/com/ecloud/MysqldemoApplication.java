package com.ecloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Administrator
 */
@SpringBootApplication
@MapperScan("com.ecloud.dao")
public class MysqldemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqldemoApplication.class, args);
    }

}
