package com.wk.boot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc： TODO
 */
@Component//将组件田间道ioc中,只有在容器中的组件才会拥有springboot的强大功能
@ConfigurationProperties("mypet")

public class Pet {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Pet() {
    }
}
