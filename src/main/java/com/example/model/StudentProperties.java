package com.example.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 自定义属性的练习
 * <p>
 * 也可以指定单独的配置文件 如：value = "classpath:config/wisely.properties"
 * Created by user on 2017/4/19.
 */

@Component
@ConfigurationProperties(prefix = "student")
public class StudentProperties {


    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
