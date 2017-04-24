package com.example.task;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 实际应用中，我们会有在项目服务启动的时候就去加载一些数据或做一些事情这样的需求。
 * 为了解决这样的问题，Spring Boot 为我们提供了一个方法，通过实现接口 CommandLineRunner 来实现。
 * <p>
 * 很简单，只需要一个类就可以，无需其他配置。
 * 创建实现接口 com.kfit.runner.CommandLineRunner 的类
 * <p>
 * Created by user on 2017/4/24.
 */

@Component
@Order(value = 1)
public class MyStartupRunner1 implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {

        System.out.println(">>>>>>>>>>>>>>>服务启动执行，执行加载数据等操作 11111111 <<<<<<<<<<<<<");

    }

}
