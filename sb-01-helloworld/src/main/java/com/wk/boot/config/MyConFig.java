package com.wk.boot.config;

import com.wk.boot.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author： 魏凯
 * @version: 1.0
 * @desc：
 * 1. 配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2. 配置类本身也是组件
 * 3. proxyBeanMethods:代理bean的方法   ,这个是@Configuration注解中默认为true的属性
 * FuLL( proxyBeanMethods = true) .Lite( proxyBeanMethods = false)组件依赖
 */
@Configuration(proxyBeanMethods = true)//告诉springboot这是一个配置类等价于配置文件
public class MyConFig {

    /*
    * 外部无论对配置类中的这个组件注册方法调用多少次获取的都是之前注册容器中的单实例
    * 若不写@Bean，则并不能创建组件
     * */
    @Bean()//给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型。返回的值,就是组件在容器中的实例
    public Person person01(){
        return new Person("zhangsan",50);
    }
    @Bean("person")//重命名，名字不在是方法名，而是（）中的名字
    public Person person02(){
        return new Person("xiaohong",66);
    }
}