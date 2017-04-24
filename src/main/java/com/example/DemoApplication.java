package com.example;

import com.example.model.StudentProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @EnableScheduling 定时任务生效
 * </>
 * @EnableAsync 异步任务生效
 * </>
 * @EnableConfigurationProperties 自己添加配置
 */


/**
 * 在开发中我们知道Spring Boot默认会扫描启动类同包以及子包下的注解，
 * 那么如何进行改变这种扫描包的方式呢，
 * 原理很简单就是：
 *
 * @ComponentScan注解进行指定要扫描的包以及要扫描的类。
 * 如:
 * @ComponentScan(basePackages={"cn.kfit","org.kfit"})
 */
@SpringBootApplication
@MapperScan("com.example.dao")
@EnableScheduling
@EnableAsync
@EnableConfigurationProperties(StudentProperties.class)
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
