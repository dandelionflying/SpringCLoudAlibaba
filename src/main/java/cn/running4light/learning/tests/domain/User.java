package cn.running4light.learning.tests.domain;

import org.springframework.stereotype.Component;

/**
 * @author running4light
 * @description
 * @createTime 2021/7/9 15:24
 */
//@Component
public class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
