package com.flow.eda.lean;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.flow.eda.lean.mapper")  // 扫描正确的 Mapper 包路径
public class WareApplication {

    public static void main(String[] args) {
        // 启动 Spring Boot 应用
        SpringApplication.run(WareApplication.class, args);
    }
}
